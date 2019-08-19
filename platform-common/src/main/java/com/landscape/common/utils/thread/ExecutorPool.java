package com.landscape.common.utils.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.landscape.exceptions.pool.BasicThreadException;
import com.landscape.exceptions.pool.ThreadExecException;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池工具
 *
 * @author : eddie
 * @date : 2019-08-17
 */
@Slf4j
public final class ExecutorPool {

    /**
     * 线程池
     */
    private ExecutorService service;

    /**
     * 信号锁
     */
    private Semaphore semaphore;

    /**
     * MAX线程因子
     */
    private static final int FACTOR = 2;

    private static final AtomicInteger TOTAL_EXECUTOR_POOL_SIZE = new AtomicInteger(0);

    private static final ConcurrentHashMap<String, ExecutorPool> EXECUTOR_POOL_CACHE = new ConcurrentHashMap<>();

    /**
     * 私有构造函数
     * @param threadTotal   核心线程数
     * @param nameFormat    线程名称格式
     */
    private ExecutorPool(int threadTotal, String nameFormat){
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat(nameFormat).build();
        this.service = new ThreadPoolExecutor(threadTotal, threadTotal * FACTOR + 1, 5L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(256), factory, new ThreadPoolExecutor.AbortPolicy());
        //初始化信号量
        this.semaphore = new Semaphore(threadTotal);
    }

    /**
     * 执行工作
     * @param action    lambda表达式，要做的工作
     */
    public void doWork(WorkAction action) {
        try {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    action.execute();
                } catch (InterruptedException e) {
                    throw new ThreadExecException("线程执行异常: {}", e.getMessage());
                }finally {
                    semaphore.release();
                }
            });
        }catch (ThreadExecException e){
            this.shutDown();
            throw new BasicThreadException(e);
        }
    }

    /**
     * 关闭一个线程池
     */
    private void shutDown(){
        try {
            service.shutdown();
            service.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("线程池关闭异常: {}", e.getMessage(), e);
        }
    }

    /**
     * 双重检查单例
     * @param threadTotal   核心线程数 同时可执行线程数
     * @param poolName      线程池名称
     * @return
     */
    public static ExecutorPool getInstance(int threadTotal, String poolName){
        if(Objects.isNull(EXECUTOR_POOL_CACHE.get(poolName))){
            synchronized (ExecutorPool.class){
                if (Objects.isNull(EXECUTOR_POOL_CACHE.get(poolName))) {
                    String identify = poolName.concat("-pool-%d");
                    ExecutorPool executorPool = new ExecutorPool(threadTotal, identify);
                    EXECUTOR_POOL_CACHE.put(poolName, executorPool);
                    TOTAL_EXECUTOR_POOL_SIZE.addAndGet(1);
                }
            }
        }
        return EXECUTOR_POOL_CACHE.get(poolName);
    }

    static int getPoolSize(){
        return TOTAL_EXECUTOR_POOL_SIZE.get();
    }

    static void killThreadPool(String poolName){
        ExecutorPool remove = EXECUTOR_POOL_CACHE.remove(poolName);
        if (Objects.isNull(remove)){
            return;
        }
        TOTAL_EXECUTOR_POOL_SIZE.decrementAndGet();
        remove.shutDown();
    }

}