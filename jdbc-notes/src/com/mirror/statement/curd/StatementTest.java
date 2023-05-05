package com.mirror.statement.curd;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class StatementTest {
    @Test
    public void statementTest(){
        //使用Statement的弊端 要拼写sql语句 并且存在sql注入的问题
        //如何避免出现sql注入 只要用PreparedStatement(从Statement扩展而来)取代Statement
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String user=sc.next();
        System.out.println("请输入密码: ");
        String password=sc.next();
        String sql="select user,password from user_table where user='1' or ' AND password = '=1 or '1' = '1'";
//        String sql="select user,password from user_table where user='"+ user +"' AND password = '"+ password +"'";
        User returnUser=get(sql, User.class);
        if(returnUser!=null){
            System.out.println("登入成功");
        }
        else{
            System.out.println("登入失败");
        }
    }

    //使用Statement实现对数据表的查询操作
    public <T> T get(String sql,Class<T> clazz) {
        T t=null;
        Connection connection=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            //连接数据库过程
            ClassLoader classLoader=ClassLoader.getSystemClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
            Properties properties=new Properties();
            properties.load(resourceAsStream);
            String url=properties.getProperty("url");
            String user=properties.getProperty("user");
            String password=properties.getProperty("password");
            String driverClass=properties.getProperty("driverClass");
            Class.forName(driverClass);
            connection= DriverManager.getConnection(url,user,password);

            st=connection.createStatement();
            rs=st.executeQuery(sql);

            //获取结果集的元数据
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取结果集的列数
            int columnCount=rsmd.getColumnCount();

            if(rs.next()){
                t=clazz.newInstance();
                for(int i=0;i<columnCount;i++){
                    //获取列名称
    //                String columnName=rsmd.getColumnName(i+1);

                    //获取列的别名
                    String columnName=rsmd.getColumnLabel(i+1);

                    //根据列名获得对应数据表中的数据
                    Object columnValue=rs.getObject(columnName);

                    //将数据表中得到的数据封装进对象
                    Field field=clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
