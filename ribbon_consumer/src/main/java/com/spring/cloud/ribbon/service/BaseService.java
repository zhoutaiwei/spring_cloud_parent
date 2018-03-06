package com.spring.cloud.ribbon.service;

public class BaseService {
    public String helloFallback(String name){
        return  "error："+name;
    }
}
