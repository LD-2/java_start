package com.mirror.annotation.dao2.impl;

import com.mirror.annotation.dao2.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoForMySql implements UserDao {
    @Override
    public void insert() {
        System.out.println("Mysql数据库正在插入数据");
    }
}
