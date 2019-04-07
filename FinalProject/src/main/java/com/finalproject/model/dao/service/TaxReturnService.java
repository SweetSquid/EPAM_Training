package com.finalproject.model.dao.service;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.TaxReturnDao;
import com.finalproject.model.dao.UserDao;
import com.finalproject.model.entity.TaxReturn;
import com.finalproject.model.entity.User;

import java.util.Optional;

public class TaxReturnService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public Optional<TaxReturn> id(int id) {
        Optional<TaxReturn> result;
        try (TaxReturnDao taxReturnDao = daoFactory.createTaxReturn()) {
            result = taxReturnDao.findById(id);
        }
        return result;
    }
}
