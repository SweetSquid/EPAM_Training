package com.model.entity;

public enum NotebookDB {
    Sasha("Oleksandr","sashasuper"),
    Kolya("Kolya","qwe12345"),
    Masha("Masha","prosto123");

    private String name;
    private String login;

    NotebookDB(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public String getName(){
        return name;
    }

    public String getLogin(){
        return login;
    }

    public static boolean checkLogin(String login){
        for (NotebookDB nb: NotebookDB.values()) {
           if (login.equals(nb.login)){
                return false;
           }
        }
        return true;
    }

    public static boolean checkEmail(String email){
        for (NotebookDB nb: NotebookDB.values()) {
           if (email.equals(nb.login)){
                return false;
           }
        }
        return true;
    }
}
