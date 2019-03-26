package com.regform.model.entity;

public class WrongLoginException extends Exception {

    public WrongLoginException(String message) {
        super(message);
    }
}
