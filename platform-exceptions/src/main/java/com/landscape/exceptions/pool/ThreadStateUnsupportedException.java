package com.landscape.exceptions.pool;

/**
 * @author eddie
 * @createTime 2019-05-30
 * @description 当前状态不允许更改
 */
public class ThreadStateUnsupportedException extends BasicThreadException {

    public ThreadStateUnsupportedException(String format, Object... args) {
        super(format, args);
    }

    public ThreadStateUnsupportedException(String message) {
        super(message);
    }
}
