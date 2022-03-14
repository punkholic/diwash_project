package com.example.database.Model;

import com.example.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class StockBook {

    private final Connection connection;
    private final String tableName;

    public StockBook(){
        this.tableName = "stock_book";
        this.connection = DatabaseConnection.getInstance();
    }

    public ArrayList<com.example.database.TableClasses.StockBook> get() throws SQLException {
        ArrayList<com.example.database.TableClasses.StockBook> stockBooks = new ArrayList<>();

        String sql = "SELECT * FROM " + tableName;
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        com.example.database.TableClasses.StockBook stockBook;
        while (resultSet.next()){
            stockBook = new com.example.database.TableClasses.StockBook(
                    resultSet.getInt("receipt_amount"),
                    resultSet.getString("miti"),
                    resultSet.getString("particulars"),
                    resultSet.getString("receipt_quantity"),
                    resultSet.getString("receipt_rate"),
                    resultSet.getString("issued_quantity"),
                    resultSet.getString("balance_quantity"),
                    resultSet.getString("remarks"),
                    resultSet.getString("article_name")
            );
            stockBook.setId(resultSet.getInt("id"));
            stockBooks.add(stockBook);
        }
        return stockBooks;
    }

    public void insert(com.example.database.TableClasses.StockBook stockBook) throws SQLException{
        String sql = "INSERT INTO " + this.tableName + " VALUES(null,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1,  stockBook.getReceipt_amount());
        preparedStatement.setString(2, stockBook.getMiti());
        preparedStatement.setString(3, stockBook.getParticulars());
        preparedStatement.setString(4, stockBook.getReceipt_quantity());
        preparedStatement.setString(5, stockBook.getReceipt_rate());
        preparedStatement.setString(6, stockBook.getIssued_quantity());
        preparedStatement.setString(7, stockBook.getBalance_quantity());
        preparedStatement.setString(8, stockBook.getRemarks());
        preparedStatement.setString(9, stockBook.getArticle_name());
        preparedStatement.execute();
    }

    public ArrayList<com.example.database.TableClasses.StockBook> search(String articleName) throws SQLException{
        ArrayList<com.example.database.TableClasses.StockBook> stockBooks = new ArrayList<>();

        String sql = "SELECT * FROM " + tableName + " WHERE article_name = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setString(1, articleName);
        ResultSet resultSet = statement.executeQuery();
        com.example.database.TableClasses.StockBook stockBook;
        while (resultSet.next()){
            stockBook = new com.example.database.TableClasses.StockBook(
                    resultSet.getInt("receipt_amount"),
                    resultSet.getString("miti"),
                    resultSet.getString("particulars"),
                    resultSet.getString("receipt_quantity"),
                    resultSet.getString("receipt_rate"),
                    resultSet.getString("issued_quantity"),
                    resultSet.getString("balance_quantity"),
                    resultSet.getString("remarks"),
                    resultSet.getString("article_name")
            );
            stockBook.setId(resultSet.getInt("id"));
            stockBooks.add(stockBook);
        }
        return stockBooks;
    }

    public void update(com.example.database.TableClasses.StockBook stockBook) throws SQLException {

        String sql = "UPDATE " + this.tableName + " SET receipt_amount = ?," +
                "miti = ?," +
                "particulars = ?," +
                "receipt_quantity = ?," +
                "receipt_rate = ?," +
                "issued_quantity = ?," +
                "balance_quantity = ?," +
                "remarks = ?," +
                "article_name = ? " +
                "WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1,  stockBook.getReceipt_amount());
        preparedStatement.setString(2, stockBook.getMiti());
        preparedStatement.setString(3, stockBook.getParticulars());
        preparedStatement.setString(4, stockBook.getReceipt_quantity());
        preparedStatement.setString(5, stockBook.getReceipt_rate());
        preparedStatement.setString(6, stockBook.getIssued_quantity());
        preparedStatement.setString(7, stockBook.getBalance_quantity());
        preparedStatement.setString(8, stockBook.getRemarks());
        preparedStatement.setString(9, stockBook.getArticle_name());
        preparedStatement.setInt(10, stockBook.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException{
        String sql = "DELETE FROM " + this.tableName + " WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

}
