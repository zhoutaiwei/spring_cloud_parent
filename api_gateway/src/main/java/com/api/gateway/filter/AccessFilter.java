package com.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 若想该类被执行，需要为其创建具体的bean才能实现启动
 */
public class AccessFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器类型，他决定过滤器哪个请求的那个生命周期中执行，
     * pre:代表在请求路由前执行
     * routing :请求路由时执行
     * post：在route和error过滤器之后被调用
     * error：请求错误后执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序，当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤去是否被执行，在实际运用中，我们可以利用该函数来指定过滤器的有效范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
        //return (boolean)context.get("success");//返回success，说明上一个 过滤器成功了，若不成功则这个及以下的过滤器都不执行，直接返回结果
    }

    /**
     * 过滤器的具体逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
   //       doSome();
        HttpServletRequest request = context.getRequest();
        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        String token = request.getParameter("accessToken");
        if(token==null){//验证，可根据token参数进行验证
            logger.warn("access token is emtry!");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
        }
        String body = context.getResponseBody();
        context.set("success",false);
        System.out.println("ResponseBody : "+body);
        logger.info("access token ok!");

        return null;
    }
    public void doSome(){
        throw new RuntimeException("exception");
    }
}
