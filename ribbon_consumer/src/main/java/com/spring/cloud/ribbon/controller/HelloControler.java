package com.spring.cloud.ribbon.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.spring.cloud.ribbon.POJO.User;
import com.spring.cloud.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.observables.BlockingObservable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class HelloControler {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    static HystrixRequestContext context;
    static {
        context = HystrixRequestContext.initializeContext();
    }
    @Autowired
    HelloService helloService;
    @RequestMapping(value = "/hello-consumer" , method = RequestMethod.GET)
    public String hi(@RequestParam String name) {
       // HystrixRequestContext.setContextOnCurrentThread(context);缓存
        String result=helloService.hiService(name);

        return result;
    }

    @RequestMapping(value = "/hello-consumer01" , method = RequestMethod.GET)
    public User getUser(User users) throws ExecutionException, InterruptedException {
      //  User users=new User("zs",15,"gg");
        Future<User> user = helloService.getUser(users);
        User user1 = user.get();

        return user1;
    }

    @RequestMapping(value = "/hello-consumer02" , method = RequestMethod.GET)
    public String getObservableResult(String name) throws ExecutionException, InterruptedException {
        Observable<String> obsrvable = helloService.getObsrvable(name);

        Observable<List<String>> buffer = obsrvable.buffer(obsrvable.count());
        BlockingObservable<List<String>> toBlocking = buffer.toBlocking();
        Future<List<String>> listFuture = toBlocking.toFuture();
        List<String> strings = listFuture.get();
        for (int i=0;i<strings.size();i++){
            System.out.println(strings.get(i));
        }

       /* BlockingObservable<String> blocking = obsrvable.toBlocking();
        final String s = blocking.toFuture().get();*/
        return name;
    }
}