package com.mirror.spring6.service;

import com.mirror.spring6.bean.UserDao2;

public class UserService2 {
    private UserDao2 aaa;

    // 这个set方法非常关键
    public void setAaa(UserDao2 aaa) {
        this.aaa = aaa;
    }

    public void save(){
        aaa.insert();
    }
}
