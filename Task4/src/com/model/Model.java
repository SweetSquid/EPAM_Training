package com.model;


import com.model.entity.Notebook;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Notebook> notebook = new ArrayList<>();

    public void addNotebook(Notebook nb){
        notebook.add(nb);
    }

    public List<Notebook> getNotebook(){
        System.out.println(notebook);
        return notebook;
    }
}
