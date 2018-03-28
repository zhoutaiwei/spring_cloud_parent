package com.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

public class ErrorFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(ErrorFilter.class);
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();
        logger.error("This is a ErrorFilter:[{}]",throwable.getCause().getMessage());
        //设置下面这些东西好像没什么用。。。
        context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);//500
        context.set("error.exception", throwable.getCause());//异常对象
        context.set("error.message", "ErrorFilter");
        return null;
    }
}
