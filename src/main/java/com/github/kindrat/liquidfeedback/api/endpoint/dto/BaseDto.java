package com.github.kindrat.liquidfeedback.api.endpoint.dto;

import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;
import com.github.kindrat.liquidfeedback.api.util.Convertible;

import java.io.Serializable;

public abstract class BaseDto<ENTITY extends BaseEntity> implements Serializable, Convertible<ENTITY> {

    public abstract String toString();
}
