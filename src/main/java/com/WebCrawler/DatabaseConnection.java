package com.WebCrawler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static Connection connection = null;
    public static Connection getConnection(){
        if(connection!=null){
            return connection;
            // if connection is not null that means we are already having a connection
            // and hence we are retuning the from here
        }

        //if connection is null then we need to connect to the db
        String user = "root";
        String pwd = "root";;
        String db = "searchengineapp";
        return getConnection(user,pwd,db);

    }
    private static Connection getConnection(String username,String pwd, String db){//method overloading
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // calling the jdbc driver class to connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + db + "?user=" + username + "&password=" + pwd);
            // calling the default getConnection method by passing the parameters
            //in order to connect our db
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
        //returning the connection instance

    }
}
