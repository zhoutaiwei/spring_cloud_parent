package com.hystrix.dashboad;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 单个服务监控
 */
@EnableCircuitBreaker//开启断路器
@SpringBootApplication
@EnableHystrixDashboard//开启监控功能
public class HystrixApplication {
        public static void main(String[] args){
            SpringApplication.run(HystrixApplication.class,args);
        }

}
