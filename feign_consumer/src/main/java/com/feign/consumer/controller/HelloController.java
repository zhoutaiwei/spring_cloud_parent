package com.feign.consumer.controller;

import com.feign.consumer.POJO.User;
import com.feign.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Autowired
    HelloService service;

    @RequestMapping("feign-consumer")
    public String getResult(String name){
        String result = service.getFeignResult(name);
        return result;
    }
    /**
     * 参数为一个对象
     */
    @RequestMapping(value="feign-consumer02",method = RequestMethod.GET)
    public String getUserFeature(){
        User user=new User("zhoutaiwei",25,"男");
        System.out.println(user);
        return  service.getUserFeature(user);
    }

    /**
     * 返回结果我一个对象
     * @param
     * @return
     */
    @RequestMapping(value="feign-consumer03",method = RequestMethod.GET)
    public User getUser(User user){
        //User user=new User("zhoutaiwei",25,"男");
       return  service.getUser(user);
    }
}
/**/