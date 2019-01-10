package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author eddie
 * @createTime 2019-01-10
 * @description 测试控制器
 */
@Slf4j
@Controller
public class TestController {

    @GetMapping("test")
    public void test(){
        System.out.println("eee");
    }
}
