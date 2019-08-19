package com.landscape.common.utils.thread;

/**
 * 工作内容
 *
 * @author : eddie
 * @date : 2019-08-17
 */
@FunctionalInterface
public interface WorkAction {
    /**
     * 执行工作
     * @throws InterruptedException 执行异常
     */
    void execute() throws InterruptedException;
}
