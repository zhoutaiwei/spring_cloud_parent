package com.trace2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace2Application {
    Logger log= LoggerFactory.getLogger(Trace2Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class);
    }

    @RequestMapping(value = "/trace-2",method = RequestMethod.GET)
    public String getrace2(){
        log.info("this is trace2 the contriller----");
        return  "you are trace?I'm trace2";
    }
}
