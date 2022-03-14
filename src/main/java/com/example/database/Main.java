package com.example.database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)throws SQLException {
        Migration migration = new Migration();
//        migration.destroy();
        migration.migrate();
    }
}
