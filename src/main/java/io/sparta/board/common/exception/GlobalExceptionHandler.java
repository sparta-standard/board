package io.sparta.board.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(GlobalException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", e.getErrorCode().getCode());
        body.put("status", e.getErrorCode().getStatus());
        body.put("message", e.getMessage());

        return ResponseEntity.status(e.getErrorCode().getStatus()).body(body);
    }
}