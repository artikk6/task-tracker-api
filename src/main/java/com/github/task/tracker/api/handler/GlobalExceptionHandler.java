package com.github.task.tracker.api.handler;

import com.github.task.tracker.api.exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handlerBadRequest(BadRequestException e) {

        Map<String, String> error = new HashMap<>();

        error.put("error", e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(error);
    }
}
