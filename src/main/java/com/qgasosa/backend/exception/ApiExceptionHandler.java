package com.qgasosa.backend.exception;

import com.qgasosa.backend.exception.common.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LogManager.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundExceptionHandler(RuntimeException exception, HttpServletRequest req) {
        return this.buildErrorResponseEntity(exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponseEntity(RuntimeException exception, HttpStatus statusCode) {
        logger.error(exception);

        ErrorResponse error = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(error, statusCode);
    }
}
