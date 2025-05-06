package com.aula.testing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionsHandler{

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<Map<String,Object>>HandleIllegalArgumentException(IllegalAccessException erro){
        return ResponseEntity.status
                (HttpStatus.BAD_REQUEST).body(Map.of("Message", erro.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>>MethodArgumentNotValidException(MethodArgumentNotValidException erro){
        return ResponseEntity.status
                (HttpStatus.BAD_REQUEST)
                .body(Map.of("Message",erro.getFieldErrors().get(0).getDefaultMessage()));
    }
}
