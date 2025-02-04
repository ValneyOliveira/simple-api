package com.example.store.handlers;

import com.example.store.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<RestErrorMessage> customerNotFoundHandler(NotFoundException exception){
        RestErrorMessage restResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restResponse);
    }

    @ExceptionHandler(SaveErrorException.class)
    private ResponseEntity<RestErrorMessage> customerSaveErrorHandle(SaveErrorException exception){
        RestErrorMessage restResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restResponse);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage> customerAlreadyExistsHandle(SaveErrorException exception){
        RestErrorMessage restResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restResponse);
    }

    @ExceptionHandler(UpdateErrorException.class)
    private ResponseEntity<RestErrorMessage> customerUpdateErrorHandle(UpdateErrorException exception){
        RestErrorMessage restResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restResponse);
    }

    @ExceptionHandler(DeletionErrorException.class)
    private ResponseEntity<RestErrorMessage> customerDeleteErrorHandle(UpdateErrorException exception){
        RestErrorMessage restResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restResponse);
    }
}