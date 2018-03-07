package com.spring.cloud.eureka.client.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private DiscoveryClient client;
    @Value("${server.port}")
    String port;
    @RequestMapping("/hello")
    public String getJSON(String name) {
        //  return "{\"a\":[{\\\"name\\\":\\\"jobs\\\"}, {\\\"name\\\":\\\"bill\\\"},{\\\"product\\\":\\\"war3\\\"}]}"
         ServiceInstance instance=client.getLocalServiceInstance();
         //让线程等待几秒钟
        int time=new Random().nextInt(1500);
        logger.info("等待时间："+time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(name+"---hello, host : " + instance.getHost()+" service_id : "+instance.getServiceId());
        return "Hello World";
    }
}
