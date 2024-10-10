package com.example.server10.exception;

/**
 * 커스텀 예외 클래스
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}