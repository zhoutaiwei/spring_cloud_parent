package com.spring.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService extends BaseService {
	@Autowired
	RestTemplate restTemplate;
	//设置请求缓存
	@CacheResult(cacheKeyMethod = "cacheKey")
	@HystrixCommand(fallbackMethod ="helloFallback" )
	public String hiService(String name) {
		return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
    }
	/**
	 * 设置缓存key，由cacheKeyMethod指定
	 */
	public String cacheKey(String name){
		return name;
	}

	public static void main(String[] args) {
		String t="asdfasd";
	}
}
