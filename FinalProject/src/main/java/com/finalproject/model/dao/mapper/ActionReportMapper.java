package com.finalproject.model.dao.mapper;

import com.finalproject.model.entity.ActionReport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneOffset;

public class ActionReportMapper implements ObjectMapper<ActionReport> {
    @Override
    public ActionReport extractFromResultSet(ResultSet rs) throws SQLException {
        ActionReport actionReport = new ActionReport();
        actionReport.setReport_id(rs.getInt("report_id"));
        actionReport.setAction(ActionReport.Action.valueOf(rs.getString("action")));
        actionReport.setMessage(rs.getString("message"));
        actionReport.setDate(rs.getDate("date").toLocalDate().atStartOfDay(ZoneOffset.UTC).toLocalDateTime());
        return actionReport;
    }
}
