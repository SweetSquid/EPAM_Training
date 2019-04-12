package com.finalproject.model.dao.service;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.UserDao;
import com.finalproject.model.entity.User;

import java.util.Optional;

public class UserService {
    private static DaoFactory daoFactory = DaoFactory.getInstance();

    public static boolean userHasInspector(int userId){
        return !daoFactory.createTaxReturn().getUserTaxReturn(userId).isEmpty();
    }

    public Optional<User> username(String username) {
        Optional<User> result;
        try (UserDao userDao = daoFactory.createUser()) {
            result = userDao.findByType("username", username);
        }
        return result;
    }
}
