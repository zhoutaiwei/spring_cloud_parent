package com.spring.cloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloControler {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hello-consumer")
    public String hi(@RequestParam String name) {
        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
    }
}