package com.bean;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class UserA implements HttpSessionBindingListener {
    private int age;
    private String name;

    public UserA(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //数据绑定 在域中添加此类的对象的时候 就会出发此函数
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("绑定...");
    }

    //数据解绑 在域中移除此类的对象的时候 就会出发此函数
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("解绑...");
    }

    @Override
    public String toString() {
        return "UserA{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserA() {
    }
}
