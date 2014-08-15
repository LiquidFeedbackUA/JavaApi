package com.github.kindrat.liquidfeedback.api.validation;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.BaseDto;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityNotFoundException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;

public class RequestValidator<DTO extends BaseDto<ENTITY>, ENTITY extends BaseEntity<DTO>> {

    public void validateEntity(ENTITY entity) throws EntityNotFoundException {
        if (entity == null)
        {
            throw new EntityNotFoundException();
        }
    }
}
