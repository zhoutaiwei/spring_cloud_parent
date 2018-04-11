package filter.pre

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

import javax.servlet.http.HttpServletRequest

class PreFilter extends ZuulFilter{
    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 1000
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() {
        def request = RequestContext.getCurrentContext().getRequest()
        def string = request.getRequestURI().toString()
        System.out.println(string);
        return null
    }
}
