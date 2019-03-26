package com.regform.model.DAO.mapper;

public interface ObjectMapper<Entity> {
    boolean isUnique(Entity entity);
}
