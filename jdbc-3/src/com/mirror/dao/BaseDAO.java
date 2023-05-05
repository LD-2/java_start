package com.mirror.dao;

import com.mirror.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
*  DAO: data(base) access object
*  封装了对于数据表的通用操作
*/
public abstract class BaseDAO {

    //增删改
    public void update(Connection connection,String sql,Object...args){
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,preparedStatement);
        }
    }

    //查单个
    public <T>T selectOne(Connection connection,Class<T>clazz,String sql,Object...args){
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet= preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            if(resultSet.next()){
                T t = clazz.newInstance();
                for(int i=1;i<= metaData.getColumnCount();i++){
                    String name = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(name);
                    Field field =clazz.getDeclaredField(name);
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

    //查多个
    public <T>List<T> selectList(Connection connection,Class<T> clazz,String sql,Object...args){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        List<T> list= null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            list = new ArrayList<>();
            while(resultSet.next()){
                T t = clazz.newInstance();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String name = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(name);
                    Field field =clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,preparedStatement,resultSet);
        }
        return list;
    }

    //查询某个特殊数据
    public <E>E getValue(Connection connection,String sql,Object...args){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){
                return (E)resultSet.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,preparedStatement,resultSet);
        }
        return null;
    }
}
