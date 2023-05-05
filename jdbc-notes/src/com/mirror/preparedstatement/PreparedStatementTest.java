package com.mirror.preparedstatement;

import com.mirror.bean.Customer;
import com.mirror.statement.curd.User;
import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreparedStatementTest {
    @Test
    public void statementTest() throws SQLException, IOException, NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        //PreparedStatement之所以安全是因为预编译了sql语句关系直接先确定了 默认选择问号的内容就可以了  关系不会被改变

        //使用Statement的弊端 要拼写sql语句 并且存在sql注入的问题
        //如何避免出现sql注入 只要用PreparedStatement(从Statement扩展而来)取代Statement
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String user=sc.next();
        System.out.println("请输入密码: ");
        String password=sc.next();
//        String sql="select user,password from user_table where user='1' or ' AND password = '=1 or '1' = '1'";
//        String sql="select user,password from user_table where user='"+ user +"' AND password = '"+ password +"'";
        String sql="select user,password,balance from user_table where user= ? AND password = ?";
        User returnUser=show(User.class,sql,user,password);
        if(returnUser!=null){
            System.out.println("登入成功");
            System.out.println("message: "+returnUser);
        }
        else{
            System.out.println("登入失败");
        }
    }

    public <T>T show(Class<T> clazz,String sql,Object...args) throws SQLException, IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            //1、创建连接
            connection= JDBCUtils.getConnection();
            //2、预编译sql语句
            preparedStatement = connection.prepareStatement(sql);
            //3、填充通配符
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            //4、执行sql语句
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            if(resultSet.next()){
                T t = clazz.newInstance();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String name = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(i);
                    Field field=t.getClass().getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5、关闭资源
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
