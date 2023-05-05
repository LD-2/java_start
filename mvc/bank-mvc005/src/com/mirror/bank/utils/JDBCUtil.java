package com.mirror.bank.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtil {
    //工具类的构造函数一般都是私有的
    //因为工具类的方法一般也都是静态的



    //数据库信息读取
    private static ResourceBundle bundle = ResourceBundle.getBundle("/resources/db");
    private static String driver=bundle.getString("driver");
    private static String url=bundle.getString("url");
    private static String user=bundle.getString("user");
    private static String password=bundle.getString("password");
    static{
        //注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //在 根据Map  线程和连接的关系 获取连接
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    //获取数据库连接
    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if(connection==null){
            connection = DriverManager.getConnection(url, user, password);
            threadLocal.set(connection);
        }
        return connection;
    }

    //资源关闭
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if(connection!=null){
                connection.close();

                //这里要移除 因为tomcat服务器 内置了线程池
                //线程池中有很多对象  这个对象是重复使用的 如果不回收  下次就会拿到连接关闭的线程
                threadLocal.remove();
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
