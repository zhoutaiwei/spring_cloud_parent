package com.spring.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.spring.cloud.ribbon.POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

@Service
public class HelloService extends BaseService {
    @Autowired
    RestTemplate restTemplate;


    //设置请求缓存
    //@CacheResult(cacheKeyMethod = "cacheKey")//不使用缓存啦，，，，，
    //指定断路器隔离策略为信号量，如果是并发高的时候后者报发生找不到上下文异常时候 scoped context，设置
    @HystrixCommand(fallbackMethod = "helloFallback",commandProperties = {@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")})
    public String hiService(String name) {
        return restTemplate.getForEntity("http://hello-service/hello?name={1}" , String.class, name).getBody();
    }

    /**
     * 异步单个结果 queue
     * @param user
     * @return
     */
    @HystrixCommand
    public Future<User> getUser(final User user) {

        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                //如果传入的参数是对象，则使用post方式postForObject
                User object = restTemplate.postForObject("http://hello-service/hello03", user, User.class);
                return object;
            }
        };
    }

    /**
     * 返回多个结果
     * @param name
     * @return
     */
    //@HystrixCommand(observableExecutionMode = ObservableExecutionMode.EAGER)//表示使用observable方式执行
    //@HystrixCommand(observableExecutionMode = ObservableExecutionMode.LAZY)//表示使用toObservable方式执行
    @HystrixCommand
    public Observable<String> getObsrvable(String name){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> observable) {
                if(!observable.isUnsubscribed()){
                    try {
                        String result=restTemplate.getForEntity("http://hello-service/hello?name=" + name, String.class, name).getBody();
                        //可以操作多个结果
                        observable.onNext(result);
                        observable.onNext(name);
                        observable.onCompleted();
                    } catch (RestClientException e) {
                        observable.onError(e);
                    }
                }
            }
        });
    }
}