package com.example.store.exceptions;

public class DeletionErrorException extends RuntimeException{

    public DeletionErrorException(){
        super("Error to delete!");
    }

    public DeletionErrorException(String message){
        super(message);
    }
}
