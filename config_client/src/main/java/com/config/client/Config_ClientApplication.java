package com.config.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //用来发现config-server
@SpringBootApplication
public class Config_ClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Config_ClientApplication.class).web(true).run(args);
    }
}

