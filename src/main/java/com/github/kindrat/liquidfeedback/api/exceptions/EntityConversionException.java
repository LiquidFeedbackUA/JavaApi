package com.github.kindrat.liquidfeedback.api.exceptions;

public class EntityConversionException extends Exception {
    public EntityConversionException() {
    }

    public EntityConversionException(String message) {
        super(message);
    }

    public EntityConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityConversionException(Throwable cause) {
        super(cause);
    }

    public EntityConversionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
