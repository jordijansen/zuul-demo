package com.zuuldemo.gateway.filters.exception;

import lombok.Getter;

/**
 * FilterException that can be thrown by {@link com.netflix.zuul.ZuulFilter} implementations that will be handled by the {@link com.zuuldemo.gateway.filters.ErrorFilter}.
 */
@Getter
public class FilterException extends RuntimeException {
    private int httpStatus;

    public FilterException(final int httpStatus, final String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
