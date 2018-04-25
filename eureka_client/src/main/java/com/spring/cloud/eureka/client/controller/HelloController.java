package com.spring.cloud.eureka.client.controller;


import com.spring.cloud.eureka.client.POJO.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private DiscoveryClient client;
    @Value("${server.port}")
    String port;
    @RequestMapping("/hello")
    public String getJSON(String name) {
        //  return "{\"a\":[{\\\"name\\\":\\\"jobs\\\"}, {\\\"name\\\":\\\"bill\\\"},{\\\"product\\\":\\\"war3\\\"}]}"
         ServiceInstance instance=client.getLocalServiceInstance();
         //让线程等待几秒钟
        int time=new Random().nextInt(1500);
        logger.info("等待时间："+time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(name+"---hello, host : " + instance.getHost()+" service_id : "+instance.getServiceId());
        return "Hello World";
    }

    /**
     * 参数为一个对象
     *
     */
    @RequestMapping(value="/hello02",method = RequestMethod.POST)
    public String getUserFeature(@RequestBody  User user){
        return "返回结果：name："+user.getName()+" ,age:"+user.getAge()+" ,sex:"+user.getSex();
    }

    /**
     * 返回一个对象
     * @param user
     * @return
     */
    @RequestMapping(value="/hello03",method = RequestMethod.POST)
    public User getUser(@RequestBody  User user){
        return user;
    }
    /**
     * 返回多个结果
     * @param
     * @return
     */
    @RequestMapping(value="/hello04",method = RequestMethod.POST)
    public List<User> getList(){
        User user1=new User("zs1",15,"mm");
        User user2=new User("zs2",15,"mm");
        User user3=new User("zs3",15,"gg");
        List<User> list=new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return  list;
    }

}
