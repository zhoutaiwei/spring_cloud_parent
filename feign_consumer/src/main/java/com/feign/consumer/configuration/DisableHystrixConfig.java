package com.feign.consumer.configuration;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用来关闭指定服务的hystrix
 */
@Configuration
public class DisableHystrixConfig {
    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
