package com.landscape.user.controller;

import com.el.smile.logger.event.annotation.EventTrace;
import com.el.smile.logger.event.model.LoggerType;
import com.el.smile.logger.logger.Slf4jEventLogger;
import com.el.smile.util.LocalDataUtils;
import com.landscape.user.repository.TraceIdServiceProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信发送控制器
 * <p>
 * 2019-08-15
 *
 * @author eddie
 */
@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SmsSenderController {

    private final TraceIdServiceProvider traceIdServiceProvider;

    @GetMapping("/test/api")
    @EventTrace(event = "测试", loggerType = LoggerType.JSON)
    public String test() {
        log.info(LocalDataUtils.getTraceId());
        LocalDataUtils.setIsSucess(true);
        return traceIdServiceProvider.test();
    }

}
