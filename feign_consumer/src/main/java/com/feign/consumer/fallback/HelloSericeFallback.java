package com.feign.consumer.fallback;

import com.feign.consumer.POJO.User;
import com.feign.consumer.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 降级处理类，在HelloService的@FeignClient注解中指定 生效
 */
@Component("fallback")
public class HelloSericeFallback implements HelloService {
    @Override
    public String getFeignResult(@RequestParam(value = "name") String  name){
        return "error:fallback";
    }

    @Override
    public String getUserFeature(@RequestBody User user) {
        return "error:fallback";
    }

    @Override
    public User getUser(@RequestBody  User user){
        return new User("null",0,"null");
    }
}
