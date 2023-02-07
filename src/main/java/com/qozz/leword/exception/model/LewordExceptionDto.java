package com.qozz.leword.exception.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LewordExceptionDto {

    private final String message;
    private final String status;
    private final Integer code;

    public LewordExceptionDto(String message, HttpStatus status) {
        this.message = message;
        this.status = status.getReasonPhrase();
        this.code = status.value();
    }

}
