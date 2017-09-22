package com.zuuldemo.gateway.metrics;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.stereotype.Repository;

/**
 * MetricRepository for storing metrics.
 */
@Repository
public class MetricRepository {

    @Getter
    private Map<String, Integer> metrics = new HashMap<>();

    public void addMetric(String requestURI) {
        metrics.putIfAbsent(requestURI, 0);
        metrics.computeIfPresent(requestURI, (s, integer) -> integer + 1);
    }

}
