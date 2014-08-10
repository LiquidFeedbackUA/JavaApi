package com.github.kindrat.liquidfeedback.api.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public interface Convertible<T extends Serializable> {

    public T convertAndGet() throws InvocationTargetException, IllegalAccessException;
}
