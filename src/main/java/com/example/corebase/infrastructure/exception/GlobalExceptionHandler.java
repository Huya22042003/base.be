package com.example.corebase.infrastructure.exception;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception ex) {
        Gson gson = new Gson();
        if (ex instanceof BadRequestCustomException) {
            System.out.println(gson.toJson(ex.getMessage()) + "BadRequestCustomException");
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        } else if (ex instanceof NoSuchElementException) {
            return ResponseEntity.notFound().build();
        } else {
            System.out.println(gson.toJson(ex.getMessage()) + "INTERNAL_SERVER_ERROR");
            ex.printStackTrace();
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
