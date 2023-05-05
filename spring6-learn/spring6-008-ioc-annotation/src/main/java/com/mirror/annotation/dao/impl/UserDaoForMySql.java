package com.mirror.annotation.dao.impl;

import com.mirror.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoForMySql implements UserDao {
    @Override
    public void insert() {
        System.out.println("正在向mysql数据库插入user数据");
    }

}
