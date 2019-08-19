package com.landscape.exceptions.pool;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.helpers.MessageFormatter;

/**
 * @author eddie
 * @createTime 2019-05-27
 * @description 生产者消费者基础异常
 */
@Slf4j
public class BasicThreadException extends RuntimeException{

    public BasicThreadException(String format, Object... args) {
        super(MessageFormatter.arrayFormat(format, args).getMessage());
        log.error(this.getMessage());
    }

    public BasicThreadException(String message) {
        super(message);
        log.error(this.getMessage());
    }


    public BasicThreadException(String message, Throwable cause) {
        super(message, cause);
        log.error(this.getMessage());
    }

    public BasicThreadException(Throwable cause) {
        super(cause);
        log.error(this.getMessage());
    }

}
