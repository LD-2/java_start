package com.mirror.user.web;

import com.mirror.user.service.UserService;
import com.mirror.user.service.impl.UserServiceImpl;

public class UserAction {
    private UserService userServiceImpl = new UserServiceImpl();
    public void login(String username,String password) throws Exception {
        userServiceImpl.login(username,password);
    }
}
