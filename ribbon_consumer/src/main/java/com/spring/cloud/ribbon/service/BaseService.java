package com.spring.cloud.ribbon.service;

public class BaseService {
    /**
     * 降级方法
     * @param name
     * @param t
     * @return
     */
    public String helloFallback(String name,Throwable t){
        if(null==t){
            System.out.println("请求不成功，但没有异常");
        }else{
            System.out.println("出现异常:"+t);
        }

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
