package com.example.healthcare_management_system;

import java.sql.*;

public class databaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/healthcare_management_system";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}