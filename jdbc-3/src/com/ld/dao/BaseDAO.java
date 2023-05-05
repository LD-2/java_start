package com.ld.dao;

import com.ld.util.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/*
*  DAO: data(base) access object
*  封装了对于数据表的通用操作
*/
public abstract class BaseDAO<T> {
    Class<T> clazz=null;
    //静态代码块>匿名代码块>构造函数
    //继承泛型类 不是泛型类 则父类泛型类要指明参数
    //抽象类又构造函数 但是接口没
    //泛型类中的泛型方法 和 泛型类中的泛型没有关联

    //获取子类对象的继承泛型父类的泛型类型
    {
        //获取带泛型的父类
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType=(ParameterizedType) genericSuperclass;

        Type[] actualTypeArguments = paramType.getActualTypeArguments();//获取了父类的泛型参数
        clazz=(Class<T>)actualTypeArguments[0];
    }
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
    public T selectOne(Connection connection,String sql,Object...args){
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
    public List<T> selectList(Connection connection,String sql,Object...args){
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
