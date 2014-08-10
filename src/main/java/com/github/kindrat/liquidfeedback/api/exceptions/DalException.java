package com.github.kindrat.liquidfeedback.api.exceptions;

public class DalException extends Exception {

    public DalException() {
    }

    public DalException(String message) {
        super(message);
    }

    public DalException(String message, Throwable cause) {
        super(message, cause);
    }

    public DalException(Throwable cause) {
        super(cause);
    }

    public DalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
