package com.gdinesh.taskmanager.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleInternalServerError(Exception ex) {
        RestTemplate restTemplate = new RestTemplate();
        return new ResponseEntity<>("Project with Id " + ex.getMessage() +" doesn't exist.", HttpStatus.NOT_FOUND);
    }
}
