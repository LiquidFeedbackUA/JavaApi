package com.github.kindrat.liquidfeedback.api.persistence.entity;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.BaseDto;
import com.github.kindrat.liquidfeedback.api.util.Convertible;

import java.io.Serializable;

public abstract class BaseEntity<DTO extends BaseDto> implements Serializable, Convertible<DTO> {

    public abstract String toString();
}
