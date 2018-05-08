package com.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineApplication {
    /**
     * 集群监控 ,要在hystrix-dashboard的127.0.0.1:2000/hystrix中加入http://127.0.0.1:8989/hystrix.stream
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class,args);
    }
}
