package project.model;

public class NotUniqueSongException extends Exception {
    public NotUniqueSongException(){
        super("Not unique song");
    }
}
