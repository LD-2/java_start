package com.mirror.transaction;

import com.mirror.bean.Order;
import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;

public class CRUDTest {
    @Test
    public void test01() throws Exception {
        Connection connection=JDBCUtils.getConnection();
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);//事务结束就没了 重启mysql默认 或者手动设置全局
        System.out.println(connection.getTransactionIsolation());
        String sql="select order_id id,order_name name,order_date date from `order` where order_id=?";
        Order user1=select(connection, Order.class,sql,4);
        System.out.println(user1);
    }

    @Test
    public void test02() throws Exception{
        Connection connection=JDBCUtils.getConnection();
        connection.setAutoCommit(false);
        String sql="update `order` set order_name=? where order_id=?";
        update(connection,sql,"GEGE",4);
        Thread.sleep(1500);
        connection.commit();
    }

    public void update(Connection connection, String sql, Object...args){
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,preparedStatement);
        }
    }

    public <T>T select(Connection connection,Class<T>clazz,String sql, Object...args){
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            if(resultSet.next()){
                T t = clazz.newInstance();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String name=metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(name);
                    Field field=clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,preparedStatement,resultSet);
        }
        return null;
    }
}
