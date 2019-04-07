package com.finalproject.model.entity;

import java.time.*;
import java.util.Objects;

public class TaxReturn {
    private int id;
    private int userId;
    private int inspectorId;
    private Category category;
    private LocalDateTime date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public enum Category{
        WATER_TAX,
        LAND_TAX,
        TRANSPORT_TAX,
        EXCISE_TAX,
        INCOME_TAX;
    }

    @Override
    public String toString() {
        return "TaxReturn{" +
                "id=" + id +
                ", userId=" + userId +
                ", inspectorId=" + inspectorId +
                ", category=" + category +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxReturn taxReturn = (TaxReturn) o;
        return id == taxReturn.id &&
                userId == taxReturn.userId &&
                inspectorId == taxReturn.inspectorId &&
                category == taxReturn.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, inspectorId, category);
    }
}
