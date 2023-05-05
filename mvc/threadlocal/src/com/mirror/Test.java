package com.mirror;

public class Test {
    public static void main(String[] args) {

        //测试线程
        Thread thread=Thread.currentThread();
        System.out.println(thread);

        UserService userService=new UserService();
        userService.save();
    }
}
