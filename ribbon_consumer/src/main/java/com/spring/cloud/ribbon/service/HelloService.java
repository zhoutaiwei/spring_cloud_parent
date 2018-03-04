package com.spring.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod = "hellofallback")
	public String hiService(String name) {
        return restTemplate.getForObject("http://hello-service/hello?name="+name,String.class);
    }
	public String hellofallback(String name){
		return "服务调用失败，我是fallback，"+name;
	}
}
