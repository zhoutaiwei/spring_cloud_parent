package com.spring.cloud.ribbon.service;

public class BaseService {
    public String helloFallback(String name,Throwable t){

        System.out.println("超时或出现异常"+t.getMessage());
        return  "error："+name;
    }
}
