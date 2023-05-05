package com.mirror.spring6.service;

import com.mirror.spring6.dao.UserDao;
import com.mirror.spring6.dao.VipDao;

public class UserService {
    private UserDao userDao;
    private VipDao vipDao;

    // 使用set方式注入，必须提供set方法。
    // 反射机制要调用这个方法给属性赋值的。

    public void setVip(VipDao vipDao){
        this.vipDao = vipDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }

    public void save2(){
        vipDao.insert();
    }
}
