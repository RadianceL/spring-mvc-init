package com.landscape.community.controller;

import com.el.smile.util.TraceLocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * since 6/25/20
 *
 * @author eddie
 */
@Slf4j
@RestController
public class TraceIdController {

    @PostMapping("/provider/test/api")
    public String test() {
        log.info(TraceLocalUtils.getTraceId());
        return "success " + TraceLocalUtils.getTraceId();
    }
}