package com.zuuldemo.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zuuldemo.gateway.filters.exception.FilterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Error filter that handles any {@link FilterException}s that may occur.
 */
@Slf4j
@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("[ErrorFilter] Error occurred");
        final RequestContext currentContext = RequestContext.getCurrentContext();
        final Throwable throwable = currentContext.getThrowable();
        final Throwable cause = throwable.getCause();
        if (cause instanceof FilterException) {
            final FilterException filterException = (FilterException) cause;
            currentContext.setResponseStatusCode(filterException.getHttpStatus());
            currentContext.setResponseBody(filterException.getMessage());

            currentContext.remove("throwable");
            return null;
        }

        return null;
    }
}
