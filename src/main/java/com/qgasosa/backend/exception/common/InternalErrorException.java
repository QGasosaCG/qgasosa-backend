package com.qgasosa.backend.exception.common;

public class InternalErrorException extends RuntimeException {

    private final static String INTERNAL_ERROR = "Internal server error.";

    public InternalErrorException() {
        super(INTERNAL_ERROR);
    }

    public InternalErrorException(String message) {
        super(message);
    }
}
