package com.example.listener.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author eddie
 * @createTime 2018-11-30
 * @description
 */
@Slf4j
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 原子操作，基于CAS算法完成
     */
    private volatile AtomicBoolean isInit=new AtomicBoolean(false);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //防止重复触发
        if(!isInit.compareAndSet(false,true)) {
            return;
        }
        log.info("初始化执行序列 - 监听器，获取配置文件中内容");
    }

}
