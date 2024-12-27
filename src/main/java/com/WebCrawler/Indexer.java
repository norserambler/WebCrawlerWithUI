package com.WebCrawler;

import org.jsoup.nodes.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Indexer {
    static Connection connection = null;

    Indexer (Document document,String url){
        //select important elements of the document object
        String title = document.title();
        String link = url;
        String text = document.text();
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into pages values(?,?,?);");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, url);
            preparedStatement.setString(3, text);
            preparedStatement.executeUpdate();

            // preparing queries to execute in db.
            // we will get the document class and URL from WebCrawler class
        }catch(SQLException exception){
            exception.printStackTrace();

        }

    }
}

