package com.mirror.mvc;


import com.mirror.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * AccountDao这个类是一个针对表t_act只进行数据库CRUD操作的组件
 * 什么是DAO?
 *  DAO是javaee是设计模式之一（非23种设计模式）
 *  Data Access Object （数据访问对象）
 *  DAO 只进行数据库的CRUD操作 不进行进行业务逻辑
 *  一般一张表对应一个DAO对象  一张表对应一个此表的数据访问对象 此对象封装了数据库中对此表的数据的crud操作
 *
 */
public class AccountDao {

    //Account表中添加记录操作
    public int insert(Account account){
        PreparedStatement preparedStatement=null;
        int count=0;
        try {
            //获取连接对象
            Connection connection = JDBCUtil.getConnection();
            System.out.println(connection);
            //预编译sql语句
            String sql="insert into `t_act` (actno,balance)values(?,?)";
            preparedStatement=connection.prepareStatement(sql);
            //填充占位符
            preparedStatement.setString(1,account.getActno());
            preparedStatement.setDouble(2,account.getBalance());
            //执行sql语句
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtil.close(null,preparedStatement,null);
        }
        return count;
    }

    //Account表中删除数据操作
    public int deleteById(Long id){
        PreparedStatement preparedStatement=null;
        int count=0;
        try {
            //获取连接对象
            Connection connection = JDBCUtil.getConnection();
            System.out.println(connection);
            //预编译sql语句
            String sql="delete from `t_act` where id=?";
            preparedStatement=connection.prepareStatement(sql);
            //填充占位符
            preparedStatement.setLong(1,id);
            //执行sql语句
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtil.close(null,preparedStatement,null);
        }
        return count;
    }

    //Account表中改动数据
    public int update(Account account){
        PreparedStatement preparedStatement=null;
        int count=0;
        try {
            //获取连接对象
            Connection connection = JDBCUtil.getConnection();
            System.out.println(connection);
            //预编译sql语句
            String sql="update `t_act` set actno=?,balance=? where id=?";
            preparedStatement=connection.prepareStatement(sql);
            //填充占位符
            preparedStatement.setString(1,account.getActno());
            preparedStatement.setDouble(2,account.getBalance());
            preparedStatement.setLong(3,account.getId());
            //执行sql语句
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtil.close(null,preparedStatement,null);
        }
        return count;
    }

    //查询操作 单个数据
    public Account selectByActno(String actno){
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Account account=null;
        try {
            //获取连接对象
            Connection connection = JDBCUtil.getConnection();
            System.out.println(connection);
            //预编译sql语句
            String sql="select id,actno,balance from `t_act` where actno = ?";
            preparedStatement=connection.prepareStatement(sql);
            //填充占位符
            preparedStatement.setString(1,actno);
            //执行sql语句
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String actno1 = resultSet.getString("actno");
                Double balance = resultSet.getDouble("balance");
                account = new Account(id, actno1, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtil.close(null,preparedStatement,null);
        }
        return account;
    }

    //查询Account表中所有数据
    public List<Account> selectList(){
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Account> list=new ArrayList<Account>();
        try {
            //获取连接对象
            Connection connection = JDBCUtil.getConnection();
            System.out.println(connection);
            //预编译sql语句
            String sql="select id,actno,balance from `t_act`";
            preparedStatement=connection.prepareStatement(sql);
            //执行sql语句
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String actno = resultSet.getString("actno");
                Double balance = resultSet.getDouble("balance");
                list.add(new Account(id, actno, balance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtil.close(null,preparedStatement,null);
        }
        return list;
    }
}
