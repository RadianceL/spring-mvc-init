package com.example;

import com.example.listener.spring.ApplicationStartup;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

/**
 * @author eddie
 * @createTime 2019-03-17
 * @description 启动类
 */
@Slf4j
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.example.dao")
public class SpringApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication springApplication = new org.springframework.boot.SpringApplication(SpringApplication.class);
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
    }

    /**
     * 初始化执行
     */
    @PostConstruct
    public void init(){
        log.info("初始化执行序列 - 启动类初始化方法");
    }

}
