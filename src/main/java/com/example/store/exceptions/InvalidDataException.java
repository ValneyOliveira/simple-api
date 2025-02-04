package com.example.store.exceptions;

public class InvalidDataException extends RuntimeException{

    public InvalidDataException(){
        super("Invalid Data !");
    }

    public InvalidDataException(String message){
        super(message);
    }
}
