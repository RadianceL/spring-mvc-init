package com.example.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author eddie
 * @createTime 2019-03-17
 * @description 项目核心配置项
 */
@Data
@Component
@ConfigurationProperties(prefix = "test")
public class ApplicationCoreConfiguration {

    /**
     * 测试字段
     */
    private String value;
}
