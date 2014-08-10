package com.github.kindrat.liquidfeedback.api.persistence.entity;

import com.github.kindrat.liquidfeedback.api.dto.ApiDto;
import com.github.kindrat.liquidfeedback.api.util.Convertible;

import java.io.Serializable;

public interface BaseEntity<DTO extends ApiDto> extends Serializable, Convertible<DTO> {

    public String toString();
}
