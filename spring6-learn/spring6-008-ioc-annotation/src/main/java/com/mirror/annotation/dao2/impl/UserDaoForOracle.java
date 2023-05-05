package com.mirror.annotation.dao2.impl;


import com.mirror.annotation.dao2.UserDao;
import org.springframework.stereotype.Repository;


//@Repository
public class UserDaoForOracle implements UserDao {
    @Override
    public void insert() {
        System.out.println("向oracle数据库中插入数据");
    }
}
