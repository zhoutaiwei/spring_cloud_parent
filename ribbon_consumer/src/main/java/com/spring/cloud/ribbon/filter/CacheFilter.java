package com.spring.cloud.ribbon.filter;


import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(filterName = "CacheFilter",urlPatterns = "/*",asyncSupported = true)
public class CacheFilter implements Filter{
    HystrixRequestContext context;
    public void init(FilterConfig filterConfig) throws ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            context.shutdown();
        }

    }

    public void destroy() {

    }
}
