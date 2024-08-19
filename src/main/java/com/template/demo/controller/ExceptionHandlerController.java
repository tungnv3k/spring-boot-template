package com.template.demo.controller;

import com.template.demo.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> unknownException(Exception ex) {
        return ResponseEntity.internalServerError().body(ExceptionResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, ex));
    }
}
