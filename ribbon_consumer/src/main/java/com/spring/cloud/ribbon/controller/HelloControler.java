package com.spring.cloud.ribbon.controller;

import com.spring.cloud.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloControler {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hello-consumer" , method = RequestMethod.GET)
    public String hi(@RequestParam String name) {
        String result=helloService.hiService(name);

        return result;
    }
}