package com.spring.cloud.ribbon.service;

public class BaseService {
    /**
     * 降级方法
     * @param name
     * @param t
     * @return
     */
    public String helloFallback(String name,Throwable t){

        System.out.println("超时或出现异常"+t.getMessage());
        return  "error："+name;
    }

    /**
     * 设置缓存key，由cacheKeyMethod指定
     */
    public String cacheKey(String name) {

        System.out.println("调用缓存方法。。。。。");
        return name;
    }
}
