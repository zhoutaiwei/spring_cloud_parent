package filter.prod

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.apache.zookeeper.proto.GetChildrenRequest

import javax.servlet.http.HttpServletResponse

class ProdFilter extends ZuulFilter{
    @Override
    String filterType() {
        return "post"
    }

    @Override
    int filterOrder() {
        return 2000
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() {
        def response = RequestContext.getCurrentContext().getResponse()
        response.getOutputStream().print(",i am zhoutaiwei")
        response.flushBuffer()
        return null
    }
}
