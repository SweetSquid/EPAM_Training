package com.finalproject.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/finalproject?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
    }
}
