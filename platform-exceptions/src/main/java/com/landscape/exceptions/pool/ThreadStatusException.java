package com.landscape.exceptions.pool;

/**
 * @author eddie
 * @createTime 2019-06-05
 * @description 容器状态异常
 */
public class ThreadStatusException extends BasicThreadException {

    public ThreadStatusException(String format, Object... args) {
        super(format, args);
    }

    public ThreadStatusException(String message) {
        super(message);
    }
}
