package ua.training.model.entity;

public class WrongEmailException extends Exception {
    WrongEmailException(){
        super();
    }

    public WrongEmailException(String message){
        super(message);
    }

}
