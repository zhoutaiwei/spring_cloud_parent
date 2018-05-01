package com.zuul.dynamic.filter.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import com.zuul.dynamic.filter.POJO.User;

@Service
public class AggregationService {
    @Autowired
    private RestTemplate rt;
    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserAge01(int age){
        //创建一个观察者
        return Observable.create(observer ->{
            User user = rt.getForObject("http://hello-service/hello03?name={1}&age={2}", User.class, "zhoutaiwei",age);
            observer.onNext(user);
            observer.onCompleted();
        });
    }
    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserAge02(int age){
        //创建一个观察者
        return Observable.create(observer ->{
            User user = rt.getForObject("http://hello-service/hello03?name={1}&age={2}", User.class, "zhoutaiwei",age);
            observer.onNext(user);
            observer.onCompleted();
        });
    }
    public User fallback(int  age) {
        User user = new User();
        user.setAge(age);
        return user;
    }
}
