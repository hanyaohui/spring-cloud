package com.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class MyFilter extends ZuulFilter {

    @Override
    public String filterType() { // 定义filter的类型，有pre、route、post、error四种
        return "pre";
    }

    @Override
    public int filterOrder() { // filter的顺序，数字越小表示顺序越高，越先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() { // 表示是否需要执行该filter
        return true;
    }

    @Override
    public Object run() { // filter需要执行的具体操作
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        requestContext.getResponse().setContentType("text/html;charset=UTF-8");
        String token = request.getParameter("token");

        if (StringUtils.isEmpty(token)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(400);
            requestContext.setResponseBody("缺少token参数");
            return null;
        } else if (!token.equals("010")) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token不匹配");
            return null;
        } else {
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(200);
            return null;
        }
    }
}
