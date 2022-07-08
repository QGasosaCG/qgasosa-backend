package com.qgasosa.backend.exception.common;

public class ConflictException extends RuntimeException{

    public ConflictException(String message) {
        super(message);
    }
}
