package com.landscape.exceptions.basic;

import com.landscape.exceptions.core.BasicRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.helpers.MessageFormatter;

/**
 * @author eddie
 * @createTime 2018-12-01
 * @description 自定义基础异常
 */
@Slf4j
public class BusinessBasisRuntimeException extends BasicRuntimeException {

    public BusinessBasisRuntimeException() {
        super();
        log.error(this.getMessage());
    }

    public BusinessBasisRuntimeException(String format, Object... args) {
        super(MessageFormatter.arrayFormat(format, args).getMessage());
        log.error(this.getMessage());
    }

    public BusinessBasisRuntimeException(String message) {
        super(message);
        log.error(this.getMessage());
    }


    public BusinessBasisRuntimeException(String message, Throwable cause) {
        super(message, cause);
        log.error(this.getMessage());
    }

    public BusinessBasisRuntimeException(Throwable cause) {
        super(cause);
        log.error(this.getMessage());
    }

    public BusinessBasisRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(this.getMessage());
    }

}
