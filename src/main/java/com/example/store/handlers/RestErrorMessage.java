package com.example.store.handlers;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {
    private HttpStatus status;
    private String message;

    public RestErrorMessage(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    private HttpStatus getStatus(){
        return status;
    }
    private void setStatus(HttpStatus status){
        this.status = status;
    }

    private String getMessage(){
        return message;
    }
    private void setMessage(String message){
        this.message = message;
    }
}
