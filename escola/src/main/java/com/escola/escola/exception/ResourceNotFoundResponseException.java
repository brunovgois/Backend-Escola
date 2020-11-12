package com.escola.escola.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ResourceNotFoundResponseException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(ResourceNotFoundException ex, HttpServletRequest httpServletRequest ){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                status.getReasonPhrase(),
                ex.getMessage(),
                status.value(),
                httpServletRequest.getServletPath(),
                ex.getClass().getName()
        );

        return new ResponseEntity<>(exceptionResponse, status);
    }
}
