package com.feign.consumer002.configuration;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

/**
 * 配置日志
 */
@Configuration
public class FeignLogConfiguration {
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
