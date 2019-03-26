package com.regform.model.DAO;

import com.regform.model.entity.WrongLoginException;

import java.util.List;

public interface GenericNotebookDAO<Entity, Key> extends AutoCloseable {
    List<Entity> getAll();
    boolean create(Entity model) throws WrongLoginException;
    Entity read(Key key);
    boolean update(Entity model, Key key);
    boolean delete(Key key);
}
