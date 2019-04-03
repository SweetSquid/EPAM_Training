package com.finalproject.model.dao.service;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.UserDao;
import com.finalproject.model.entity.User;

import java.util.Optional;

public class UserService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public Optional<User> login(String login) {
        Optional<User> result;
        try (UserDao userDao = daoFactory.createUser()) {
            result = userDao.findByLogin(login);
        }
        return result;
    }
}
