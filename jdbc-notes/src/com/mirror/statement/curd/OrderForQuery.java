package com.mirror.statement.curd;

import com.mirror.bean.Order;
import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;

//数据库表中数据列可以起别名





public class OrderForQuery {

    //加单引号的目的是为了防止命名的字段和系统内部的关键字发生冲突
    @Test
    public void test02(){
        String sql="select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order = orderForQuery(sql, 2);
        System.out.println(order);
    }
    /**
     * order的通用的查询模板
     *
     */
    public Order orderForQuery(String sql,Object...args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int column=metaData.getColumnCount();//获取结果集的列
            if(resultSet.next()){//判断是否有下一个值
                Order order=new Order();
                for(int i=1;i<=column;i++){
                    String name=metaData.getColumnLabel(i);//Label获取别名  如果没有别名就是获取列名
                    Object value=resultSet.getObject(i);
                    Field field=Order.class.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(order,value);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }

    /**
     * test
     *
     *
     */
    @Test
    public void test() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            //1、连接数据库
            connection= JDBCUtils.getConnection();
            //2、预编译sql语句
            String sql="select order_name,order_date`order` from `order` where order_id = ?";
            preparedStatement =connection.prepareStatement(sql);
            //3、填充通配符
            preparedStatement.setInt(1,2);
            //4、执行sql
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                String orderName = resultSet.getString(1);
                java.sql.Date orderDate = resultSet.getDate(2);
                Order order = new Order(2, orderName, orderDate);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、关闭资源
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }

    }
}
