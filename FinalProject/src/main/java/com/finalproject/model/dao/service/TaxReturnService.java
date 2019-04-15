package com.finalproject.model.dao.service;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.TaxReturnDao;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.entity.TaxReturn;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

public class TaxReturnService {
    private static DaoFactory daoFactory = DaoFactory.getInstance();

    public static Optional<TaxReturn> id(int id) {
        Optional<TaxReturn> result;
        try (TaxReturnDao taxReturnDao = daoFactory.createTaxReturn()) {
            result = taxReturnDao.findById(id);
        }
        return result;
    }

    public static List<TaxReturn> inspectorList(int inspectorId) {
        try (JDBCTaxReturnFactory dao = daoFactory.createTaxReturn()) {
            return dao.getInspectorTaxReturn(inspectorId);
        }
    }

    public static TaxReturn create(int userId, int inspectorId, String category, Double wage, Double militaryCollection, Double incomeTax){
        try (JDBCTaxReturnFactory dao = daoFactory.createTaxReturn()){
            TaxReturn taxReturn = new TaxReturn();
            taxReturn.setUserId(userId);
            taxReturn.setInspectorId(inspectorId);
            taxReturn.setCategory(category);
            taxReturn.setDate(LocalDateTime.now());
            taxReturn.setWage(wage);
            taxReturn.setMilitaryCollection(militaryCollection);
            taxReturn.setIncomeTax(incomeTax);
            dao.create(taxReturn);
            return taxReturn;
        }
    }

    public static TaxReturn getTaxReturnByActionId(int id){
        try (JDBCTaxReturnFactory dao = daoFactory.createTaxReturn()) {
            return dao.getTaxReturnByActionId(id);
        }
    }

    public static int getInspectorId(int userId){
        try (JDBCTaxReturnFactory dao = daoFactory.createTaxReturn()) {
            return dao.getInspectorId(userId);
        }
    }

    public static TaxReturn edit(int editActionId, String category,
                               String wage, String militaryCollection, String incomeTax) {
        try (JDBCTaxReturnFactory dao = daoFactory.createTaxReturn()) {
            TaxReturn taxReturn = dao.getTaxReturnByActionId(editActionId);
            taxReturn.setCategory(category);
            taxReturn.setDate(LocalDateTime.now());
            taxReturn.setWage(Double.parseDouble(wage));
            taxReturn.setMilitaryCollection(Double.parseDouble(militaryCollection));
            taxReturn.setIncomeTax(Double.parseDouble(incomeTax));
            dao.update(taxReturn, taxReturn.getId());
            return taxReturn;
        }
    }
    public static boolean taxReturnHasReport(int id){
        try (JDBCTaxReturnFactory dao = daoFactory.createTaxReturn()) {
            return dao.taxReturnHasReport(id);
        }
    }
}
