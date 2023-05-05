package com.mirror.preparedstatement;

import com.mirror.bean.Order;
import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementQueryTest {
    //返回多条记录的写法
    @Test
    public void test01(){
        String sql="select order_id orderId,order_name orderName,order_date orderDate from `order`";
        List<Order>list=new ArrayList<>();
        list=select(Order.class,sql);
        list.forEach(System.out::println);
    }
    public <T> List<T> select(Class<T> clazz,String sql,Object...args) {
        List<T> list=new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            //1、创建连接
            connection=JDBCUtils.getConnection();
            //2、预编译sql语句
            preparedStatement=connection.prepareStatement(sql);
            //3、填充通配符
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            //4、执行sql语句
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            while(resultSet.next()){
                T t = clazz.newInstance();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String name = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(i);
                    Field field=t.getClass().getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、关闭资源
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }


    //返回一条记录的写法
    @Test
    public void test(){
        String sql="select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order=new Order();
        try {
            order=show(Order.class,sql,4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(order);
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
