package com.github.kindrat.liquidfeedback.api.service;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.BaseDto;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityConversionException;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityNotFoundException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<DTO extends BaseDto<ENTITY>, ENTITY extends BaseEntity<DTO>> {

    public abstract List<DTO> getPageStartingWithId(PageRequest request) throws EntityConversionException;

    public abstract DTO getById(Long id) throws EntityNotFoundException, EntityConversionException;

    public List<DTO> convertToApiDto(Iterable<ENTITY> entities) throws EntityConversionException {
        List<DTO> dtoList = new ArrayList<>();
        for (ENTITY entity : entities) {
            dtoList.add(entity.convertAndGet());
        }
        return dtoList;
    }
}
