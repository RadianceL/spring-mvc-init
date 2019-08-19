package com.landscape.exceptions.pool;

/**
 * @author eddie
 * @createTime 2019-05-30
 * @description 线程关闭异常
 */
public class ThreadExecException extends BasicThreadException {

    public ThreadExecException(String format, Object... args) {
        super(format, args);
    }

    public ThreadExecException(String message) {
        super(message);
    }
}
