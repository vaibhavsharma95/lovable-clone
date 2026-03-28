package com.demo.lovable_clone.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

public record ApiError (
        HttpStatus status,
        String message,
        Instant timestamp,
        List<ApiFeildError> errors
){

    public ApiError(HttpStatus status, String message) {
        this(status, message, Instant.now(), null);
    }

    public ApiError(HttpStatus status, String message, List<ApiFeildError> errors) {
        this(status, message, Instant.now(), errors);
    }
}

record ApiFeildError(
        String field,
        String message
) {
}