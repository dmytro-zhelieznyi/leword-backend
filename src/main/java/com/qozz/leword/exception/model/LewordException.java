package com.qozz.leword.exception.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public class LewordException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

}
