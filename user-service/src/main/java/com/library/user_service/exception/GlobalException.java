package com.library.user_service.exception;

import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException extends RuntimeException {

    @ExceptionHandler(UserNotFindException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFindException ex) {
        Map<String,String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(ValidationException ex) {
        Map<String,String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Validation failed: " + ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
