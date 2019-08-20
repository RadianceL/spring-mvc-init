package com.landscape.exceptions.core;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.helpers.MessageFormatter;

/**
 * @author eddie
 * @createTime 2019-07-02
 * @description 基础捕获异常
 */
@Slf4j
public class BasicCheckedException extends Exception {


    public BasicCheckedException() {
        super();
        log.error(this.getMessage());
    }

    public BasicCheckedException(String format, Object... args) {
        super(MessageFormatter.arrayFormat(format, args).getMessage());
        log.error(this.getMessage());
    }

    public BasicCheckedException(String message) {
        super(message);
    }


    public BasicCheckedException(String message, Throwable cause) {
        super(message, cause);
        log.error(this.getMessage());
    }

    public BasicCheckedException(Throwable cause) {
        super(cause);
        log.error(this.getMessage());
    }

    public BasicCheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(this.getMessage());
    }
}
