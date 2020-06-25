package com.landscape.user.controller;

import com.el.smile.util.TraceLocalUtils;
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
    public String test() {
        log.info(TraceLocalUtils.getTraceId());
        return traceIdServiceProvider.test();

    }

}
