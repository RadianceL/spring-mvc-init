package com.example.exceptions.exception;

/**
 * @author eddie
 * @createTime 2018-12-01
 * @description 自定义基础异常
 */
public class LxInterfaceException extends RuntimeException {

    public LxInterfaceException() {
        super();
    }

    public LxInterfaceException(String message) {
        super(message);
    }

    public LxInterfaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LxInterfaceException(Throwable cause) {
        super(cause);
    }

    public LxInterfaceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
