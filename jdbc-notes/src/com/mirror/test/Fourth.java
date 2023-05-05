package com.mirror.test;

import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Scanner;

public class Fourth {
    @Test
    public void test(){
        Scanner sc=new Scanner(System.in);
        String sql="delete from examstudent where ExamCard = ?";
        System.out.println("请输入考生的考号: ");
        String str=sc.next();
        int count=update(sql,str);
        if(count!=0){
            System.out.println("删除成功！");
        }else {
            System.out.println("查无此人，请重新输入！");
        }
    }

    public int update(String sql,Object...args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= JDBCUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0; i<args.length; i++) {
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
