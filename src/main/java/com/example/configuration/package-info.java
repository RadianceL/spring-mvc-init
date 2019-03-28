/**
 * @author eddie
 * @createTime 2019-03-17
 * @description
 *
 * 该包存放所有项目配置 {@link org.springframework.boot.context.properties.ConfigurationProperties spring-boot-configuration-processor}
 * 通过application配置文件自动获取参数 并实例化加入Spring IOC容器
 *
 * 使用方式：
 * private String value;
 *
 * @AutoWried
 * private void (ApplicationCoreConfiguration config){
 *     this.value = config.getValue();
 * }
 *
 */
package com.example.configuration;

