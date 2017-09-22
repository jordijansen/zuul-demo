package com.zuuldemo.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zuuldemo.gateway.filters.exception.FilterException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * AuthenticationFilter 'pre' filter that makes sure that calls to /users* have a valid token present in the Authorization header.
 */
@Slf4j
@Component
public class AuthenticationPreFilter extends ZuulFilter {

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
        final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        if (request.getRequestURI().startsWith("/users")) {
            log.info("[AuthenticationPreFilter] Request does not require authentication.");
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        if (!"Bearer a-very-secret-token".equals(request.getHeader("Authorization"))) {
            throw new FilterException(HttpStatus.UNAUTHORIZED.value(), "Request is not authorized");
        }
        log.info("[AuthenticationPreFilter] Request is authorized.");
        return null;
    }
}
