package org.windwant.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 18-8-13.
 */
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
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
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("send " + request.getMethod() + ", request to " + request.getRequestURL().toString());
        Object token = request.getParameter("accessToken");
        if(token == null){
            System.out.println("access token is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(404);
            return null;
        }
        System.out.println("access ok");
        return null;
    }
}
