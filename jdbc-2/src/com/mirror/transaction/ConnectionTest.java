package com.mirror.transaction;

import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    public void test() throws SQLException, IOException, ClassNotFoundException {
        String sql1="update user_table set balance=balance-100 where user=?";
        String sql2="update user_table set balance=balance+100 where user=?";
        update(sql1,"AA");
        //模拟网络异常
        System.out.println(10/0);
        update(sql2,"BB");
    }
    public void update(String sql,Object...args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=JDBCUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }
    }

    //考虑数据库事务后的转账操作
    @Test
    public void test02() {
        Connection connection=null;
        try {
            connection=JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql1="update user_table set balance=balance-100 where user=?";
            String sql2="update user_table set balance=balance+100 where user=?";
            newUpdate(connection,sql1,"AA");
            //模拟网络异常
            System.out.println(10/0);
            newUpdate(connection,sql2,"BB");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        } finally {
            JDBCUtils.closeResource(connection,null);
        }

    }

    public void newUpdate(Connection connection,String sql,Object...args){
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
}
