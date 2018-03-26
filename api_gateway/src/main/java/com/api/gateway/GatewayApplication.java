package com.api.gateway;


import com.api.gateway.filter.AccessFilter;
import com.api.gateway.filter.ErrorFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
    @Bean
    public AccessFilter getAccessFilter(){
        return new AccessFilter();
    }
    @Bean
    public ErrorFilter getErrorFilter(){
        return new ErrorFilter();
    }
}
