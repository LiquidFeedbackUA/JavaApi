package com.github.kindrat.liquidfeedback.api.endpoint.dto;

import org.springframework.data.domain.Sort;

public enum OrderType {
    LOGIN(new Sort(Sort.Direction.DESC, "login")),
    CREATED(new Sort(Sort.Direction.DESC, "created")),
    BOTH(new Sort(Sort.Direction.DESC, "login", "created"));

    private final Sort sort;

    OrderType(Sort sort) {
        this.sort = sort;
    }

    public Sort getSort() {
        return sort;
    }
}
