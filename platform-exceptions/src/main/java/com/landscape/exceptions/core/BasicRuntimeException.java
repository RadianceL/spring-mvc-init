package com.landscape.exceptions.core;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.helpers.MessageFormatter;

/**
 * @author eddie
 * @createTime 2018-12-01
 * @description 自定义基础异常
 */
@Slf4j
public class BasicRuntimeException extends RuntimeException {

    public BasicRuntimeException() {
        super();
        log.error(this.getMessage());
    }

    public BasicRuntimeException(String format, Object... args) {
        super(MessageFormatter.arrayFormat(format, args).getMessage());
        log.error(this.getMessage());
    }

    public BasicRuntimeException(String message) {
        super(message);
    }


    public BasicRuntimeException(String message, Throwable cause) {
        super(message, cause);
        log.error(this.getMessage());
    }

    public BasicRuntimeException(Throwable cause) {
        super(cause);
        log.error(this.getMessage());
    }

    public BasicRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(this.getMessage());
    }

}
