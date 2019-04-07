package com.finalproject.model.dao;

import com.finalproject.model.entity.TaxReturn;

import java.util.List;
import java.util.Optional;

public interface TaxReturnDao extends GenericDao<com.finalproject.model.entity.TaxReturn> {
    boolean changeInspector(int inspectorId, int userId);

    List<TaxReturn> getUserTaxReturn(int userId);
    List<TaxReturn> getInspectorTaxReturn(int inspectorId);
    Optional<TaxReturn> findById(int id);

}
