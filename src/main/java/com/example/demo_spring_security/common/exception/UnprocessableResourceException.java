package com.example.demo_spring_security.common.exception;

public class UnprocessableResourceException extends RuntimeException {
    public UnprocessableResourceException(String message) {
        super(message);
    }
}
