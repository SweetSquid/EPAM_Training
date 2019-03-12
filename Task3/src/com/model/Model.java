package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykyta Frolov
 */
public class Model {
    private String name;
    private String secondName;
    private String username;
    private String email;
    private String phone;
    private List<String> notebook = new ArrayList<String>();

    public void setName(String name){
        this.name = name;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    public String getSecondName(){
        return secondName;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public List<String> getNotebook(){
        return notebook;
    }

    public void addToNotebook(String data){
        notebook.add(data);
    }

}
