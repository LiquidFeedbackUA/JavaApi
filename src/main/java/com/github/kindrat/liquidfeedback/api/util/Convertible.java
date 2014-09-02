package com.github.kindrat.liquidfeedback.api.util;

import com.github.kindrat.liquidfeedback.api.exceptions.EntityConversionException;

import java.io.Serializable;

public interface Convertible<T extends Serializable> {

    public T convertAndGet() throws EntityConversionException;
}
