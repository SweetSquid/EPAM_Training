package com.finalproject.model.dao;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {

    boolean create(T entity);

    T readId(int id);

    List<T> readAll();

    void update(T t);

    void delete(int id);

    void close();

}
