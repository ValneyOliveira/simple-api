package com.example.store.exceptions;

public class UpdateErrorException extends RuntimeException {

    public UpdateErrorException(){
        super("Error to update!");
    }

    public UpdateErrorException(String message){
        super(message);
    }
}
