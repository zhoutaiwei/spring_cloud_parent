package com.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient //用来注册到服务中心
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {


    //http://127.0.0.1:7002/bus/refresh?destination=customers:7003 忽略指定client的更新
    public static void main(String[] args) {
            new SpringApplicationBuilder(ConfigApplication.class).web(true).run(args);
    }
}
