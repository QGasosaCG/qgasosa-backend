package com.qgasosa.backend.exception.common;

public abstract class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
