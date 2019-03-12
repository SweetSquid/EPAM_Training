package com.model.entity;

public class WrongLoginException extends Exception {

    WrongLoginException(){
        super();
    }

    public WrongLoginException(String message){
        super(message);
    }
}
