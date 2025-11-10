package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDataSource {
    private static final String userName = "postgres";
    private static final String password = "1234";
    private static final String connectionsURL  = "jdbc:postgresql://localhost:5432/testdb";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionsURL, userName, password);
    }
}
