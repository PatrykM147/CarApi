package com.example.carapi.controller.advice;

import com.example.carapi.exceptions.EntityNotFoundException;
import com.example.carapi.exceptions.response.EntityNotFoundResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundResponse> handleEntityNotFoundException(EntityNotFoundException exc) {
        return ResponseEntity.status(NOT_FOUND).body(new EntityNotFoundResponse(exc.getId(), exc.getName()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ConstraintValidationErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exc){
        return ResponseEntity.status(BAD_REQUEST).body(new ConstraintValidationErrorResponse(
                exc.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList()
        ));
    }

    record ConstraintValidationErrorResponse(List<String> codes){};
}
