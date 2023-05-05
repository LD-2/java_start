package com.mirror.user.controller;

import com.mirror.user.service.UserService;
import com.mirror.user.service.impl.UserServiceImpl;
import com.mirror.user.web.UserAction;

public class UserController {
    public static void main(String[] args) throws Exception {
        UserAction userAction = new UserAction();
        String username = "mirror";
        String password = "123456";
        userAction.login(username,password);
    }
}
