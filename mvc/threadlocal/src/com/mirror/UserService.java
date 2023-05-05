package com.mirror;

public class UserService {
    private UserDao userDao=new UserDao();
    public void save(){

        //测试线程
        Thread thread=Thread.currentThread();
        System.out.println(thread);

        //开启事务
        Connection connection=DBUtils.getConnection();
        System.out.println(connection);

        userDao.insert();
    }
}
