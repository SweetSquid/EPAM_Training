package com.finalproject.model.dao.mapper;

import com.finalproject.model.entity.TaxReturn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneOffset;

public class TaxReturnMapper implements ObjectMapper<TaxReturn> {

    @Override
    public TaxReturn extractFromResultSet(ResultSet rs) throws SQLException {
        TaxReturn taxReturn = new TaxReturn();
        taxReturn.setId(rs.getInt("tax_return_id"));
        taxReturn.setUserId(rs.getInt("user_id"));
        taxReturn.setInspectorId(rs.getInt("inspector_id"));
        taxReturn.setCategory(TaxReturn.Category.valueOf(rs.getString("category_id")));
        //TODO убрать потерю часов, минут и секунд
        taxReturn.setDate(rs.getDate("date").toLocalDate().atStartOfDay(ZoneOffset.UTC).toLocalDateTime());
        return taxReturn;
       
    }


}
