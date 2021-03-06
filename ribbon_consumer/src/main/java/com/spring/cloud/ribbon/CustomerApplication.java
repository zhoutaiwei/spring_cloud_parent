package com.spring.cloud.ribbon;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@EnableCircuitBreaker//开启断路器，也可应使用@SpringCloudApplication ,他包含了以下三个注解
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
public class CustomerApplication {


    @Bean
    @LoadBalanced    //表明这个restRemplate开启负载均衡的功能
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        //启动HystrixRequestContext
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        SpringApplication.run(CustomerApplication.class, args);

    }
}