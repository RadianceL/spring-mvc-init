package com.landscape.user.repository;

import com.el.smile.logger.event.annotation.EventTrace;
import com.el.smile.logger.event.model.LoggerType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * since 6/25/20
 *
 * @author eddie
 */
@FeignClient(name = "landscape-community", contextId = "traceIdServiceProvider")
public interface TraceIdServiceProvider {


    /**
     * 支付宝单笔打款
     * @return
     */
    @PostMapping(value = "/provider/test/api")
    @EventTrace(event = "test - /provider/test/api", loggerType = LoggerType.JSON)
    String test();

}
