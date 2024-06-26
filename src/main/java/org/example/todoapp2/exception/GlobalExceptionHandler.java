package org.example.todoapp2.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(InvalidParamsExeption.class)
    public ResponseEntity<String> handleUserAlreadyExists(InvalidParamsExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TodoNotFoundExeption.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(InvalidParamsExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
       // log.error(ex.getMessage());
        return new ResponseEntity<>("An enexpected error occured" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
