package com.mirror.test;

import com.mirror.bean.Student;
import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Scanner;

public class Third {
    @Test
    public void test(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择你要输入的内容: ");
        System.out.println("a: 准考证号");
        System.out.println("b: 身份证号");
        String str=sc.next();
        String sql="";
        if(str.equals("a")) {
            sql = "select FlowId,Type,IDCard,ExamCard,StudentName,Location,Grade from examstudent where ExamCard=?";
            System.out.println("请输入准考证号: ");
            String x=sc.next();
            Student student = select(Student.class, sql, x);
            if(student!=null){
                System.out.println("-------------------");
                System.out.println("查询结果: ");
                System.out.println(student);
            }else{
                System.out.println("查无此人！请重新进入程序");
            }
        }
        else if(str.equals("b")){
            sql = "select FlowId,Type,IDCard,ExamCard,StudentName,Location,Grade from examstudent where IDCard=?";
            System.out.println("请输入身份证号: ");
            String x=sc.next();
            Student student = select(Student.class, sql, x);
            if(student!=null){
                System.out.println("-------------------");
                System.out.println("查询结果: ");
                System.out.println(student);
            }else{
                System.out.println("查无此人！请重新进入程序");
            }
        }
        else {
            System.out.println("您的输入有误！ 请重新进入程序。");
        }
    }

    public <T>T select(Class<T> clazz,String sql,Object...args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection= JDBCUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            if(resultSet.next()){
                T t = clazz.newInstance();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String name = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(i);
                    Field field=clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
