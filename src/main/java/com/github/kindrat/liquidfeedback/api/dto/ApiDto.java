package com.github.kindrat.liquidfeedback.api.dto;

import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;
import com.github.kindrat.liquidfeedback.api.util.Convertible;

import java.io.Serializable;

public interface ApiDto<ENTITY extends BaseEntity> extends Serializable, Convertible<ENTITY>{

    public String toString();
}
