package com.mirror.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class JDBCUtils {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
    private static String driverClass=resourceBundle.getString("driverClass");
    private static String url=resourceBundle.getString("url");
    private static String user=resourceBundle.getString("user");
    private static String password=resourceBundle.getString("password");
//
//    @Test
//    public void test() throws SQLException, ClassNotFoundException {
//        Connection connection = JDBCUtils.getConnection();
//        System.out.println(connection);
//    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName(driverClass);
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
    }
    public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
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



    @Test
    public void test() throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection2();
        System.out.println(connection);
        System.out.println(dataSource);
    }
    private static DataSource dataSource;
    static {
        try {
            //在web项目中不可以用ClassLoader.getSystemClassLoader()
//            InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties=new Properties();
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection2() throws SQLException {
        return dataSource.getConnection();
    }
}

//其实这里的删除功能想到了一种业务逻辑 先删除 如果确认 就提交连接 然后url到查询页面  取消的话数据就进行回滚


