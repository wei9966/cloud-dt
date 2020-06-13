package com.dt.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Create By WeiBin on 2020/6/9 11:39
 *
 * @author WB
 */
@Component
public class LoginFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 过滤路径配置
     *
     * @return 是否过滤成功
     */
    @Override
    public boolean shouldFilter() {
        //过滤路径
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();
        System.out.println("获取的uri" + requestURI);
        if ("/orders/save/goods".equalsIgnoreCase(requestURI)) {
            //定义过滤器是否执行，truer执行（小项目可以缓存到本地配置文件，大项目可以存储到redis中）
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            //没有输入令牌
            token = request.getParameter("token");
        }
        if (StringUtils.isBlank(token)) {
            //网关不响应
            currentContext.setSendZuulResponse(false);
            //返回状态码
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
