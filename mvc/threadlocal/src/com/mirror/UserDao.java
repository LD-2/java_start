package com.mirror;

public class UserDao {
    public void insert(){

        //测试线程
        Thread thread=Thread.currentThread();
        System.out.println(thread);

        //获取连接
        Connection connection=DBUtils.getConnection();
        System.out.println(connection);

        System.out.println("UserDao insert()");
    }
}
