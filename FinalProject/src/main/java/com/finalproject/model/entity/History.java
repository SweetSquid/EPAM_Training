package com.finalproject.model.entity;

import com.finalproject.model.entity.ActionReport.Action;

import java.time.LocalDateTime;
import java.util.Objects;

public class History {
    private int taxReturnId;
    private int report_id;
    private int userId;
    private Action action;
    private String message;
    private LocalDateTime date;

    public int getTaxReturnId() {
        return taxReturnId;
    }

    public void setTaxReturnId(int taxReturnId) {
        this.taxReturnId = taxReturnId;
    }

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return taxReturnId == history.taxReturnId &&
                report_id == history.report_id &&
                userId == history.userId &&
                action == history.action &&
                Objects.equals(message, history.message) &&
                Objects.equals(date, history.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxReturnId, report_id, userId, action, message, date);
    }

    @Override
    public String toString() {
        return "History{" +
                "taxReturnId=" + taxReturnId +
                ", report_id=" + report_id +
                ", userId=" + userId +
                ", action=" + action +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
