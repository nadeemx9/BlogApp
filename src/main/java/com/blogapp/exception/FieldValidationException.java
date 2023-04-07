package com.blogapp.exception;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;


public class FieldValidationException extends RuntimeException {

    public FieldValidationException() {
    }

    public FieldValidationException(String message) {
        super(message);
    }

    public FieldValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
