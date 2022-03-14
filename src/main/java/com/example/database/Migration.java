package com.example.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Migration {

    private final Connection connection;
    private final String[] tables;

    public Migration() {
        this.connection = DatabaseConnection.getInstance();
        this.tables = new String[]{"sell_book", "purchase_book", "stock_book"};
    }

    public void destroy() throws SQLException{
        for (String table : this.tables){
            String sql = "DROP TABLE IF EXISTS " + table;
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(sql);
        }
    }

    public void migrate() throws SQLException {
        String[] tables = new String[] {
                "CREATE TABLE IF NOT EXISTS purchase_book(" +
                        "id INTEGER PRIMARY KEY," +
                        "date DATE NOT NULL," +
                        "pragyapan_patra_number INTEGER," +
                        "aapurtikarta_nam VARCHAR(200)," +
                        "aapurtikarta_esthati_number INTEGER," +
                        "kharid_pauthari_bastu TEXT," +
                        "kharid_bastu_parimad TEXT," +
                        "jamma_kharid TEXT," +
                        "kar_chut_bastu TEXT," +
                        "kar_yogya_kharid_mulya TEXT," +
                        "kar_yogya_kharid_kar_ru TEXT," +
                        "kar_yogya_pauthari_mulya TEXT," +
                        "kar_yogya_pauthari_kar_ru TEXT," +
                        "pujigat_kar_yogya_kharid_mulya TEXT," +
                        "pujigat_kar_yogya_kharid_kar_ru TEXT" +
                ")",
                "CREATE TABLE IF NOT EXISTS sell_book(" +
                        "id INTEGER PRIMARY KEY," +
                        "date DATE NOT NULL," +
                        "bujak_number INTEGER," +
                        "kharidkarta_nam VARCHAR(200)," +
                        "kharidkarta_esthae_number INTEGER," +
                        "bastu_sewa_nam TEXT," +
                        "bastu_sewa_praimad TEXT," +
                        "jamma_bekri TEXT," +
                        "esthaniya_kar_chutko_bikri TEXT," +
                        "kar_yogya_bekri_muliya TEXT," +
                        "kar_yogya_bekri_kar_ru TEXT," +
                        "nikasi_bastu_mulya TEXT," +
                        "nikasi_bastu_desh TEXT," +
                        "nikasi_bastu_patra_no INTEGER," +
                        "nikasi_bastu_patra_miti DATE" +
                        ")",
                "CREATE TABLE IF NOT EXISTS stock_book(" +
                        "id INTEGER PRIMARY KEY," +
                        "miti DATE," +
                        "particulars TEXT," +
                        "receipt_quantity TEXT," +
                        "receipt_rate TEXT," +
                        "receipt_amount INTEGER," +
                        "issued_quantity TEXT," +
                        "balance_quantity TEXT," +
                        "remarks TEXT," +
                        "article_name TEXT" +
                        ")",
                "CREATE TABLE IF NOT EXISTS articles(" +
                        "id INTEGER PRIMARY KEY," +
                        "name VARCHAR(200)" +
                        ")"
        };

        for (String table : tables){
            connection.createStatement().executeUpdate(table);
        }
    }
}
