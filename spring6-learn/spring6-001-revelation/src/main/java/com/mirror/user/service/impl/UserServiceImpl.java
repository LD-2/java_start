package com.mirror.user.service.impl;

import com.mirror.user.dao.UserDao;
import com.mirror.user.dao.impl.UserDaoImplForMySQL;
import com.mirror.user.pojo.User;
import com.mirror.user.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDaoImplForMySQL = new UserDaoImplForMySQL();
    @Override
    public void login(String username, String password) throws Exception{
        User user = userDaoImplForMySQL.selectUser(username, password);
        if(user!=null){
            System.out.println("登入成功");
        }else{
            System.out.println("登入失败，无此用户..");
        }
    }
}
