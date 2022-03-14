package com.example.database.Model;

import com.example.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class Article {

    private final Connection connection;
    private final String tableName;

    public Article(){
        this.tableName = "articles";
        this.connection = DatabaseConnection.getInstance();
    }

    public ArrayList<com.example.database.TableClasses.Article> get() throws SQLException {
        ArrayList<com.example.database.TableClasses.Article> articles = new ArrayList<>();

        String sql = "SELECT * FROM " + tableName;
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        com.example.database.TableClasses.Article article = null;
        while (resultSet.next()){
            article = new com.example.database.TableClasses.Article(
                    resultSet.getString("name")
            );
            article.setId(resultSet.getInt("id"));
            articles.add(article);
        }
        return articles;
    }

    public void insert(com.example.database.TableClasses.Article article) throws SQLException{
        String sql = "INSERT INTO " + this.tableName + " VALUES(null,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, article.getName());
        preparedStatement.execute();
    }

    public void update(com.example.database.TableClasses.Article article) throws SQLException {
        String sql = "UPDATE " + this.tableName + " SET `name` = ? WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, article.getName());
        preparedStatement.setInt(2, article.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException{
        String sql = "DELETE FROM " + this.tableName + " WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

}
