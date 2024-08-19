package com.template.demo.dto.response;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(String status, String message) {

    public static ExceptionResponse of(HttpStatus status, Exception exception) {
        return new ExceptionResponse(status.value() + " - " + status.name(), exception.getMessage());
    }
}
