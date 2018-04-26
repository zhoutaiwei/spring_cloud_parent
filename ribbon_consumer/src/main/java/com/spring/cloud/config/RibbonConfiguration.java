package com.spring.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfiguration
{
    @Bean
    public IRule ribbonRule(){
        //设置负载均衡策略为随机策略
        return new RandomRule();
    }
}
