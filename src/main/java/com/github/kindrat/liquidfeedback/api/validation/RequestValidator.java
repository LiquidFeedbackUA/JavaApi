package com.github.kindrat.liquidfeedback.api.validation;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.BaseDto;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityNotFoundException;
import com.github.kindrat.liquidfeedback.api.exceptions.ValidationException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

public abstract class RequestValidator<DTO extends BaseDto<ENTITY>, ENTITY extends BaseEntity<DTO>> {

    public void validateEntity(ENTITY entity) throws EntityNotFoundException {
        if (entity == null) {
            throw new EntityNotFoundException();
        }
    }

    public void validateIdSet(Set<Long> ids) throws ValidationException {
        if (ids.isEmpty()){
            throw new ValidationException(Error.VALUE_REQUIRED, "ids", "id set");
        }
    }

    public void validateRequiredField(Object field, String name) throws ValidationException {
        if (field == null || (field instanceof CharSequence && StringUtils.isBlank((CharSequence) field))){
            throw new ValidationException(Error.VALUE_REQUIRED, field, name);
        }
    }

    public void validateRestrictedField(Object field, String name) throws ValidationException {
        if (field != null){
            throw new ValidationException(Error.VALUE_RESTRICTED, name, field);
        }
    }
}
