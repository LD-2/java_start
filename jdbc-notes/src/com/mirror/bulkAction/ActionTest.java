package com.mirror.bulkAction;

import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActionTest {
    @Test
    public void test(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            long start=System.currentTimeMillis();
            connection= JDBCUtils.getConnection();
            String sql="insert into goods(name)values(?)";
            preparedStatement=connection.prepareStatement(sql);
            for (int i = 1; i <= 2000; i++) {
                preparedStatement.setObject(1,"name_"+i);
                preparedStatement.execute();
            }
            long end=System.currentTimeMillis();
            System.out.println(end-start+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }
        //2753ms
    }

    @Test
    public void test02(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            long start=System.currentTimeMillis();
            connection= JDBCUtils.getConnection();
            String sql="insert into goods(name)values(?)";
            preparedStatement=connection.prepareStatement(sql);
            for (int i = 1; i <= 2000; i++) {
                preparedStatement.setObject(1,"name_"+i);
                preparedStatement.addBatch();
                if(i%500==0){
                    preparedStatement.execute();
                    preparedStatement.clearBatch();
                }
            }
            long end=System.currentTimeMillis();
            System.out.println(end-start+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }
        //365ms
    }

    @Test
    public void test03(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            long start=System.currentTimeMillis();
            connection= JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql="insert into goods(name)values(?)";
            preparedStatement=connection.prepareStatement(sql);
            for (int i = 1; i <= 2000; i++) {
                preparedStatement.setObject(1,"name_"+i);
                preparedStatement.addBatch();
                if(i%500==0){
                    preparedStatement.execute();
                    preparedStatement.clearBatch();
                }
            }
            connection.commit();
            long end=System.currentTimeMillis();
            System.out.println(end-start+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }
        //284ms
    }
}
