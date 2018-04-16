package com.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TraceApplication {
    Logger log= LoggerFactory.getLogger(TraceApplication.class);
    @LoadBalanced
    @Bean
    public RestTemplate getRestTempLate(){
        return  new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceApplication.class,args);
    }
    @RequestMapping(value ="/trace-1" ,method = RequestMethod.GET)
    public String testController(){
        log.info("this is trace1 the contriller----");
        String body = getRestTempLate().getForEntity("http://trace-2/trace-2?name=?", String.class, "zhoutaiwei").getBody();
        return body;
    }
}
