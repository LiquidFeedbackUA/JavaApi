package com.github.kindrat.liquidfeedback.api.util;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.BaseDto;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityConversionException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ConvertUtil {
    public static <DTO extends BaseDto<ENTITY>, ENTITY extends BaseEntity<DTO>> DTO convert(
            ENTITY entity, Class<DTO> clazz) throws EntityConversionException {
        try{
            DTO dto = clazz.newInstance();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new EntityConversionException(e);
        }
    }

    public static <DTO extends BaseDto<ENTITY>, ENTITY extends BaseEntity<DTO>> ENTITY convert(
            DTO dto, Class<ENTITY> clazz) throws EntityConversionException {
        try{
            ENTITY entity = clazz.newInstance();
            BeanUtils.copyProperties(dto, entity);
            return entity;
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new EntityConversionException(e);
        }
    }
}
