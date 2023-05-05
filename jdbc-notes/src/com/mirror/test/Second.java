package com.mirror.test;

import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Second {
    @Test
    public void test(){
        Scanner sc=new Scanner(System.in);
        System.out.println("四六级: ");
        int type = sc.nextInt();
        System.out.println("身份证号: ");
        String IDCard=sc.next();
        System.out.println("准考证号: ");
        String examCard=sc.next();
        System.out.println("学生姓名: ");
        String studentName=sc.next();
        System.out.println("所在城市: ");
        String location=sc.next();
        System.out.println("考试成绩: ");
        int grade=sc.nextInt();
        String sql="insert into examstudent(type,IDCard,examCard,studentName,location,grade)values(?,?,?,?,?,?)";
        int update = update(sql, type, IDCard, examCard, studentName, location, grade);
        if(update!=0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }
    public int update(String sql,Object...args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i=0; i<args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }
        return 0;
    }
}
