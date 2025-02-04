package com.example.store.exceptions;

public class SaveErrorException extends RuntimeException {

    public SaveErrorException(){
        super("Error to save!");
    }

    public SaveErrorException(String message){
        super(message);
    }
}
