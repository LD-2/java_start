package com.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtil {
    private static ResourceBundle bundle=ResourceBundle.getBundle("/resources/db");
    private static String driver=bundle.getString("driver");
    private static String url=bundle.getString("url");
    private static String user= bundle.getString("user");
    private static String password=bundle.getString("password");

    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(preparedStatement!=null){
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
