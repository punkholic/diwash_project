package com.example.database.Model;

import com.example.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class SellBook {

    private final Connection connection;
    private final String tableName;

    public SellBook(){
        this.tableName = "sell_book";
        this.connection = DatabaseConnection.getInstance();
    }

    public ArrayList<com.example.database.TableClasses.SellBook> get() throws SQLException {
        ArrayList<com.example.database.TableClasses.SellBook> sellBooks = new ArrayList<>();

        String sql = "SELECT * FROM " + tableName;
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        com.example.database.TableClasses.SellBook sellBook = null;
        while (resultSet.next()){
            sellBook = new com.example.database.TableClasses.SellBook(
                    resultSet.getInt("bujak_number"),
                    resultSet.getInt("kharidkarta_esthae_number"),
                    resultSet.getInt("nikasi_bastu_patra_no"),
                    resultSet.getString("date"),
                    resultSet.getString("nikasi_bastu_patra_miti"),
                    resultSet.getString("kharidkarta_nam"),
                    resultSet.getString("bastu_sewa_nam"),
                    resultSet.getString("bastu_sewa_praimad"),
                    resultSet.getString("jamma_bekri"),
                    resultSet.getString("esthaniya_kar_chutko_bikri"),
                    resultSet.getString("kar_yogya_bekri_muliya"),
                    resultSet.getString("kar_yogya_bekri_kar_ru"),
                    resultSet.getString("nikasi_bastu_mulya"),
                    resultSet.getString("nikasi_bastu_desh")
            );
            sellBook.setId(resultSet.getInt("id"));
            sellBooks.add(sellBook);
        }
        return sellBooks;
    }

    public void insert(com.example.database.TableClasses.SellBook sellBook) throws SQLException{
        String sql = "INSERT INTO " + this.tableName + " VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, sellBook.getBujak_number());
        preparedStatement.setInt(2, sellBook.getKharidkarta_esthae_number());
        preparedStatement.setInt(3, sellBook.getNikasi_bastu_patra_no());
        preparedStatement.setString(4, sellBook.getDate());
        preparedStatement.setString(5, sellBook.getNikasi_bastu_patra_miti());
        preparedStatement.setString(6, sellBook.getKharidkarta_nam());
        preparedStatement.setString(7, sellBook.getBastu_sewa_nam());
        preparedStatement.setString(8, sellBook.getBastu_sewa_praimad());
        preparedStatement.setString(9, sellBook.getJamma_bekri());
        preparedStatement.setString(10, sellBook.getEsthaniya_kar_chutko_bikri());
        preparedStatement.setString(11, sellBook.getKar_yogya_bekri_muliya());
        preparedStatement.setString(12, sellBook.getKar_yogya_bekri_kar_ru());
        preparedStatement.setString(13, sellBook.getNikasi_bastu_mulya());
        preparedStatement.setString(14, sellBook.getNikasi_bastu_desh());
        preparedStatement.execute();
    }

    public void update(com.example.database.TableClasses.SellBook sellBook) throws SQLException {

        String sql = "UPDATE " + this.tableName + " SET bujak_numberd = ?," +
                "kharidkarta_esthae_numberd = ?" +
                "nikasi_bastu_patra_nod = ?," +
                "dated = ?," +
                "nikasi_bastu_patra_mitid = ?," +
                "kharidkarta_namd = ?," +
                "bastu_sewa_namd = ?," +
                "bastu_sewa_praimadd = ?," +
                "jamma_bekrid = ?," +
                "esthaniya_kar_chutko_bikrid = ?," +
                "kar_yogya_bekri_muliyad = ?," +
                "kar_yogya_bekri_kar_rud = ?," +
                "nikasi_bastu_mulyad = ?," +
                "nikasi_bastu_desh = ? " +
                "WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, sellBook.getBujak_number());
        preparedStatement.setInt(2, sellBook.getKharidkarta_esthae_number());
        preparedStatement.setInt(3, sellBook.getNikasi_bastu_patra_no());
        preparedStatement.setString(4, sellBook.getDate());
        preparedStatement.setString(5, sellBook.getNikasi_bastu_patra_miti());
        preparedStatement.setString(6, sellBook.getKharidkarta_nam());
        preparedStatement.setString(7, sellBook.getBastu_sewa_nam());
        preparedStatement.setString(8, sellBook.getBastu_sewa_praimad());
        preparedStatement.setString(9, sellBook.getJamma_bekri());
        preparedStatement.setString(10, sellBook.getEsthaniya_kar_chutko_bikri());
        preparedStatement.setString(11, sellBook.getKar_yogya_bekri_muliya());
        preparedStatement.setString(12, sellBook.getKar_yogya_bekri_kar_ru());
        preparedStatement.setString(13, sellBook.getNikasi_bastu_mulya());
        preparedStatement.setString(14, sellBook.getNikasi_bastu_desh());
        preparedStatement.setInt(15, sellBook.getId());
        preparedStatement.executeUpdate();
    }
    public void delete(int id) throws SQLException{
        String sql = "DELETE FROM " + this.tableName + " WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

}
