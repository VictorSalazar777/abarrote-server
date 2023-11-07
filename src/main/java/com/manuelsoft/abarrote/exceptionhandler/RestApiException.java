package com.manuelsoft.abarrote.exceptionhandler;

import org.springframework.http.HttpStatus;

public class RestApiException extends RuntimeException {
    private HttpStatus status;
    private String message;
}
