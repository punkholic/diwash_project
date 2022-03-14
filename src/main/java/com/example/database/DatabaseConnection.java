package com.example.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn = null;

    private DatabaseConnection(){}

    public static Connection getInstance(){
        if(conn == null){
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }

}
