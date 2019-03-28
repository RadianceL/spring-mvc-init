package com.example.service.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author eddie
 * @createTime 2019-02-25
 * @description
 */
@FeignClient(name = "pingan-pay")
public interface OpenFeignServerProvider {

    /**
     * 测试使用案例
     * @param name
     * @return
     */
    @GetMapping(value = "/test")
    String test(@RequestParam("name") String name);
}
