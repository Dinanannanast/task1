package com.task.task1.controller.crud;

import com.task.task1.service.exception.BusinessEntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CrudExceptionHandler {
    @ExceptionHandler(BusinessEntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(BusinessEntityNotFoundException e, WebRequest request) {
        String errorMessage = "Entity not found";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
