package com.mirror.annotation.dao.impl;

import com.mirror.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

//@Repository
public class UserDaoOracle implements UserDao {
    @Override
    public void insert() {
        System.out.println("Oracle数据库正在插入user数据");
    }
}
