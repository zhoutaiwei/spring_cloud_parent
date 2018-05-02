package com.zuul.dynamic.filter;

import com.zuul.dynamic.filter.configuration.FilterConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@SpringCloudApplication
@EnableConfigurationProperties(FilterConfiguration.class)
public class ZuulFilterApplication {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    //filterLoader(FilterConfiguration config )还没实现

    //AggregationController可一次调用两个接口,其实ribbon的toObservable也可以
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulFilterApplication.class).web(true).run(args);
    }

   /* @Value("${zuul.filter.root}")
    String root;
    @Value("${zuul.filter.interval}")
    Integer interval;
    @Bean
    public FilterLoader filterLoader(FilterConfiguration config ){
        FilterLoader instance = FilterLoader.getInstance();
        instance.setCompiler(new GroovyCompiler());
        try {
            FilterFileManager.setFilenameFilter(new GroovyFileFilter());
            FilterFileManager.init(
                    interval,
                    config.getRoot()+"/pre", //这里写死了
                    config.getRoot()+"/prod" );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }*/
}
