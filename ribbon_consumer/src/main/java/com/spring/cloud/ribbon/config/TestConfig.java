package com.spring.cloud.ribbon.config;

import com.spring.cloud.config.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 使用ribbonClient为特定name的ribbon Client自定义配置
 * 使用@RibbonClient的cofinguration属性，指定ribbon的配置类
 */
@RibbonClient(name = "hello-service",configuration = RibbonConfiguration.class)
@Configuration
public class TestConfig {

}
