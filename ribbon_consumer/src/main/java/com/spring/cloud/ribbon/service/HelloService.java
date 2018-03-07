package com.spring.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService extends BaseService {
	@Autowired
	RestTemplate restTemplate;


	//设置请求缓存
	@CacheResult(cacheKeyMethod = "cacheKey")
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String hiService( String name) {
		return restTemplate.getForEntity("http://hello-service/hello?name="+name, String.class,name).getBody();
	}

	/**
	 * 设置缓存key，由cacheKeyMethod指定
	 */
	public String cacheKey(String name) {

		System.out.println("调用缓存方法。。。。。");
		return name;
	}

	public static void main(String[] args) {
		String t = "asdfasd";
	}
}