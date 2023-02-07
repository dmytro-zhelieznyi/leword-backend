package com.qozz.leword.exception;

import com.qozz.leword.exception.model.LewordExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<Object> handle(Exception e) {
        e.printStackTrace();
        LewordExceptionDto exceptionDto
                = new LewordExceptionDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity
                .status(exceptionDto.getCode())
                .body(exceptionDto);
    }

}
