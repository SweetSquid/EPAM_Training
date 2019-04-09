package com.finalproject.model.dao.mapper;

import com.finalproject.model.entity.TaxReturn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TaxReturnMapper implements ObjectMapper<TaxReturn> {

    @Override
    public TaxReturn extractFromResultSet(ResultSet rs) throws SQLException {
        TaxReturn taxReturn = new TaxReturn();
        taxReturn.setId(rs.getInt("tax_return_id"));
        taxReturn.setUserId(rs.getInt("user_id"));
        taxReturn.setInspectorId(rs.getInt("inspector_id"));
        taxReturn.setCategory(TaxReturn.Category.valueOf(rs.getString("category_id")));
        Timestamp date = (Timestamp) rs.getObject("date");
        //TODO убрать t из вывода
        taxReturn.setDate(date.toLocalDateTime());
        return taxReturn;
       
    }


}
