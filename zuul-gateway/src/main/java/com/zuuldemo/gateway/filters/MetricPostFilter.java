package com.zuuldemo.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zuuldemo.gateway.metrics.MetricRepository;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MetricPostFilter that collects metrics for the number of requests on a certain URI.
 */
@Slf4j
@Component
public class MetricPostFilter extends ZuulFilter {

    @Autowired
    private MetricRepository metricRepository;

    @Override
    public String filterType() {
        return "post";
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
        final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        final String requestURI = request.getRequestURI();
        metricRepository.addMetric(requestURI);
        log.info("[MetricPostFilter] URI {} has been called {} times", requestURI, metricRepository.getMetrics().get(requestURI));
        return null;
    }
}
