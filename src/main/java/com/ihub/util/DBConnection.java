package com.ihub.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/todo_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {

        Connection con = null;

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException("db connection failed ! ", e);
        }

        return con;
    }
}