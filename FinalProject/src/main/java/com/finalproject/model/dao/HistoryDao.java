package com.finalproject.model.dao;

import com.finalproject.model.entity.History;
import java.util.List;

public interface HistoryDao extends GenericDao<History> {
    List<History> getByUser(int userId);
}
