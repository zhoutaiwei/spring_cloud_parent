package com.feign.consumer.configuration;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用来关闭指定服务的hystrix，在FeignClient注解中添加configuration = DisableHystrixConfig.class即可
 */
@Configuration
public class DisableHystrixConfig {
    @Bean
    public Feign.Builder feignBuilder()
    {
     //   return Feign.builder();
        return null;
    }
}
