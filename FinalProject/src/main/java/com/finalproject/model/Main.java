package com.finalproject.model;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.UserDao;
import com.finalproject.model.dao.mapper.UserMapper;
import com.finalproject.model.entity.User;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/finalproject?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            UserDao dao = daoFactory.createUser();

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                UserMapper userMapper = new UserMapper();
                User user = userMapper.extractFromResultSet(rs);
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
