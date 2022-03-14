package com.example.database.Model;

import com.example.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class PurchaseBook {

    private final Connection connection;
    private final String tableName;

    public PurchaseBook(){
        this.tableName = "purchase_book";
        this.connection = DatabaseConnection.getInstance();
    }

    public ArrayList<com.example.database.TableClasses.PurchaseBook> get() throws SQLException {
        ArrayList<com.example.database.TableClasses.PurchaseBook> purchaseBooks = new ArrayList<>();

        String sql = "SELECT * FROM " + tableName;
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        com.example.database.TableClasses.PurchaseBook purchaseBook = null;
        while (resultSet.next()){
            purchaseBook = new com.example.database.TableClasses.PurchaseBook(
                    resultSet.getString("date"),
                    resultSet.getInt("pragyapan_patra_number"),
                    resultSet.getInt("aapurtikarta_esthati_number"),
                    resultSet.getString("aapurtikarta_nam"),
                    resultSet.getString("kharid_pauthari_bastu"),
                    resultSet.getString("kharid_bastu_parimad"),
                    resultSet.getString("jamma_kharid"),
                    resultSet.getString("kar_chut_bastu"),
                    resultSet.getString("kar_yogya_kharid_mulya"),
                    resultSet.getString("kar_yogya_kharid_kar_ru"),
                    resultSet.getString("kar_yogya_pauthari_mulya"),
                    resultSet.getString("kar_yogya_pauthari_kar_ru"),
                    resultSet.getString("pujigat_kar_yogya_kharid_mulya"),
                    resultSet.getString("pujigat_kar_yogya_kharid_kar_ru")
            );
            purchaseBook.setId(resultSet.getInt("id"));
            purchaseBooks.add(purchaseBook);
        }
        return purchaseBooks;
    }

    public void insert(com.example.database.TableClasses.PurchaseBook purchaseBook) throws SQLException{
        String sql = "INSERT INTO " + this.tableName + " VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, purchaseBook.getDate());
        preparedStatement.setInt(2, purchaseBook.getPragyapan_patra_number());
        preparedStatement.setString(3, purchaseBook.getAapurtikarta_nam());
        preparedStatement.setInt(4, purchaseBook.getAapurtikarta_esthati_number());
        preparedStatement.setString(5, purchaseBook.getKharid_pauthari_bastu());
        preparedStatement.setString(6, purchaseBook.getKharid_bastu_parimad());
        preparedStatement.setString(7, purchaseBook.getJamma_kharid());
        preparedStatement.setString(8, purchaseBook.getKar_chut_bastu());
        preparedStatement.setString(9, purchaseBook.getKar_yogya_kharid_mulya());
        preparedStatement.setString(10, purchaseBook.getKar_yogya_kharid_kar_ru());
        preparedStatement.setString(11, purchaseBook.getKar_yogya_pauthari_mulya());
        preparedStatement.setString(12, purchaseBook.getKar_yogya_pauthari_kar_ru());
        preparedStatement.setString(13, purchaseBook.getPujigat_kar_yogya_kharid_mulya());
        preparedStatement.setString(14, purchaseBook.getPujigat_kar_yogya_kharid_kar_ru());
        preparedStatement.execute();
    }

    public void update(com.example.database.TableClasses.PurchaseBook purchaseBook) throws SQLException {

        String sql = "UPDATE " + this.tableName + " SET `date` = ?," +
                "`pragyapan_patra_number` = ?," +
                "`aapurtikarta_nam` = ?," +
                "`aapurtikarta_esthati_number` = ?," +
                "`kharid_pauthari_bastu` = ?," +
                "`kharid_bastu_parimad` = ?," +
                "`jamma_kharid` = ?," +
                "`kar_chut_bastu` = ?," +
                "`kar_yogya_kharid_mulya` = ?," +
                "`kar_yogya_kharid_kar_ru` = ?," +
                "`kar_yogya_pauthari_mulya` = ?," +
                "`kar_yogya_pauthari_kar_ru` = ?," +
                "`pujigat_kar_yogya_kharid_mulya` = ?," +
                "`pujigat_kar_yogya_kharid_kar_ru` = ? " +
                "WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, purchaseBook.getDate());
        preparedStatement.setInt(2, purchaseBook.getPragyapan_patra_number());
        preparedStatement.setString(3, purchaseBook.getAapurtikarta_nam());
        preparedStatement.setInt(4, purchaseBook.getAapurtikarta_esthati_number());
        preparedStatement.setString(5, purchaseBook.getKharid_pauthari_bastu());
        preparedStatement.setString(6, purchaseBook.getKharid_bastu_parimad());
        preparedStatement.setString(7, purchaseBook.getJamma_kharid());
        preparedStatement.setString(8, purchaseBook.getKar_chut_bastu());
        preparedStatement.setString(9, purchaseBook.getKar_yogya_kharid_mulya());
        preparedStatement.setString(10, purchaseBook.getKar_yogya_kharid_kar_ru());
        preparedStatement.setString(11, purchaseBook.getKar_yogya_pauthari_mulya());
        preparedStatement.setString(12, purchaseBook.getKar_yogya_pauthari_kar_ru());
        preparedStatement.setString(13, purchaseBook.getPujigat_kar_yogya_kharid_mulya());
        preparedStatement.setString(14, purchaseBook.getPujigat_kar_yogya_kharid_kar_ru());
        preparedStatement.setInt(15, purchaseBook.getId());
        preparedStatement.executeUpdate();
    }
    public void delete(int id) throws SQLException{
        String sql = "DELETE FROM " + this.tableName + " WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

}
