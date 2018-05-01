package com.zuul.dynamic.filter.contrroller;

import com.google.common.collect.Maps;
import com.zuul.dynamic.filter.POJO.User;
import com.zuul.dynamic.filter.service.AggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;
/**
 * 可调用一次性两个接口
 */
@RestController
public class AggregationController {
  public static final Logger LOGGER = LoggerFactory.getLogger(AggregationController.class);

  @Autowired
  private AggregationService aggregationService;

  @GetMapping("/aggregate/{id}")
  public DeferredResult<HashMap<String, User>> aggregate(@PathVariable Long id) {
    Observable<HashMap<String, User>> result = this.aggregateObservable();
    return this.toDeferredResult(result);
  }

  public Observable<HashMap<String, User>> aggregateObservable() {
    // 合并两个或者多个Observables发射出的数据项，根据指定的函数变换它们
    return Observable.zip(
            this.aggregationService.getUserAge01(1),//分别两个接口
            this.aggregationService.getUserAge02(2),
            (user, movieUser) -> {
              HashMap<String, User> map = Maps.newHashMap();
              map.put("user", user);
              map.put("movieUser", movieUser);
              return map;
            }
    );
  }

  public DeferredResult<HashMap<String, User>> toDeferredResult(Observable<HashMap<String, User>> details) {
    DeferredResult<HashMap<String, User>> result = new DeferredResult<>();
    // 订阅
    details.subscribe(new Observer<HashMap<String, User>>() {
      @Override
      public void onCompleted() {
        LOGGER.info("完成...");
      }

      @Override
      public void onError(Throwable throwable) {
        LOGGER.error("发生错误...", throwable);
      }

      @Override
      public void onNext(HashMap<String, User> movieDetails) {
        result.setResult(movieDetails);
      }
    });
    return result;
  }
}