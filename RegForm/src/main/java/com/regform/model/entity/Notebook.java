package com.regform.model.entity;

public class Notebook {
    private String name;
    private String login;

    public Notebook(String name, String login) {
        this.name = name;
        this.login = login;

    }

    public String getNameNotebook() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", login: " + login;
    }
}
