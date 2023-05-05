package com.mirror.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

//    这里注册中 拦截了 account
    @RequestMapping("/user/account")
    @ResponseBody
    public String account(){
        return "/user/account";
    }

//    这里 注册中 不拦截 login
    @RequestMapping("/user/login")
    @ResponseBody
    public String login(){
        return "/user/login";
    }
}
