package com.github.kindrat.liquidfeedback.api.exceptions;

import com.github.kindrat.liquidfeedback.api.validation.Error;

public class ValidationException extends Exception {
    private final String message;

    public ValidationException(Error error, Object... args) {
        this.message = String.format(error.getMessageFormat(), args);
    }

    public String getMessage() {
        return message;
    }
}
