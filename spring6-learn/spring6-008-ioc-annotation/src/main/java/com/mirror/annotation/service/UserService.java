package com.mirror.annotation.service;

import com.mirror.annotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    @Autowired
//    @Qualifier("userDaoOracle")
    private UserDao userDao;

    @Autowired
    public UserService( UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService() {
    }

    public void save(){
        userDao.insert();
    }
}
