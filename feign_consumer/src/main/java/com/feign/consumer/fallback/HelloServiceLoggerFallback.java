package com.feign.consumer.fallback;

import com.feign.consumer.POJO.User;
import com.feign.consumer.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class HelloServiceLoggerFallback implements FallbackFactory<HelloService> {
    Logger logger = LoggerFactory.getLogger(HelloServiceLoggerFallback.class);
    @Override
    public HelloService create(Throwable throwable) {

        return new HelloService(){

            @Override
            public String getFeignResult(@RequestParam(value = "name") String  name){
                //日志最好放在回滚方法中，别放在create方法中
                logger.info("fallback; reason was:",throwable);
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
        };
    }
}
