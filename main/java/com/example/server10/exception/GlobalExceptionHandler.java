package com.example.server10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * 글로벌 예외 처리기
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 커스텀 예외 처리
     *
     * @param ex CustomException 객체
     * @return 에러 응답
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * 유효성 검증 실패 시 처리
     *
     * @param ex MethodArgumentNotValidException 객체
     * @return 에러 응답
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.joining(", "));
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), errorMessage, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * 기타 예외 처리
     *
     * @param ex Exception 객체
     * @return 에러 응답
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), "서버 오류", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

/**
 * 에러 응답 형식
 */
class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private int status;

    public ErrorResponse(LocalDateTime timestamp, String message, int status) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }

    // Getters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}