package com.github.kindrat.liquidfeedback.api.validation;

public enum Error {
    VALUE_REQUIRED("%s is not a valid value for %s"),
    VALUE_RESTRICTED("%s field should be null instead of %s");

    private final String messageFormat;

    Error(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
