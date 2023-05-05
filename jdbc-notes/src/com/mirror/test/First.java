package com.mirror.test;

import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class First {
    @Test
    public void test() throws SQLException, IOException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);

        System.out.println("请输入用户名: ");
        String name;
        name = sc.next();
        System.out.println("请输入邮箱: ");
        String email;
        email=sc.next();
        System.out.println("请输入生日: ");
        String birth;
        birth=sc.next();
        String sql="insert into customers(name,email,birth)values(?,?,?)";
        int result=update(sql,name,email,birth);
        if(result!=0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
        int x=update("delete from customers where id = ?",20);
        if(x!=0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }
    public int update(String sql,Object...args) throws SQLException, IOException, ClassNotFoundException {
        Connection connection=null;
        PreparedStatement prepareStatement=null;
        try {
            connection= JDBCUtils.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            for (int i=0; i<args.length; i++) {
                prepareStatement.setObject(i+1,args[i]);
            }
//        prepareStatement.execute();
            //返回值是boolean 这里看的是返回的是不是结果集
            return prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,prepareStatement);
        }
        return 0;
    }
}
