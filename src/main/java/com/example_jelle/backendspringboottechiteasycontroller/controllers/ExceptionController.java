package com.example_jelle.backendspringboottechiteasycontroller.controllers;

import com.example_jelle.backendspringboottechiteasycontroller.exceptions.RecordNotFoundException;
import com.example_jelle.backendspringboottechiteasycontroller.exceptions.TooLongNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object> handleIndexOutOfBounds(IndexOutOfBoundsException e) {
        return new ResponseEntity<>("Deze televisie bestaat niet (index te hoog of leeg)", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TooLongNameException.class)
    public ResponseEntity<Object> handleTooLongName(TooLongNameException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
