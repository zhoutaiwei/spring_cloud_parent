package com.feign.consumer;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class FeignApplication {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL; //记录所有请求和响应的明细，包括头信息，请求体，元数据
        //默认是none级别,不记录任何信息
        //basic，仅记录请求方法，url以及响应状态码和执行时间
        //headers，除了记录basic级别的信息外，还会记录请求和响应头信息
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
