package com.isaagerald.blog_post.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){

        ApiException apiException = new ApiException();
        apiException.setStatus(HttpStatus.BAD_REQUEST.value());
        apiException.setMessage(e.getMessage());
        apiException.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleApiRequestException(Exception e){

        ApiException apiException = new ApiException();
        apiException.setStatus(HttpStatus.BAD_REQUEST.value());
        apiException.setMessage(e.getMessage());
        apiException.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);

    }

}
