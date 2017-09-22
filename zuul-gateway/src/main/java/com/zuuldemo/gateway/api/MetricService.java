package com.zuuldemo.gateway.api;

import com.zuuldemo.gateway.metrics.MetricRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple API endpoint for retrieving metrics from the {@link MetricRepository}.
 */
@RestController
public class MetricService {

    @Autowired
    private MetricRepository metricRepository;

    @RequestMapping(path = "/metric")
    public Map<String, Integer> getMapping() {
        return metricRepository.getMetrics();
    }

}
