package com.feign.consumer.service;

import com.feign.consumer.POJO.User;
import com.feign.consumer.fallback.HelloSericeFallback;
import com.feign.consumer.fallback.HelloServiceLoggerFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "hello-service",/*fallback = HelloSericeFallback.class*/ fallbackFactory = HelloServiceLoggerFallback.class)
public interface HelloService {

        @RequestMapping("/hello")
        public String getFeignResult(@RequestParam(value = "name") String  name);

        @RequestMapping(value = "/hello02",method = RequestMethod.POST)
        public String getUserFeature(@RequestBody User user);

        @RequestMapping(value = "/hello03",method = RequestMethod.POST)
        public User getUser(@RequestBody  User user);
}
