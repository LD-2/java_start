package com.mirror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebInFAction {

    @RequestMapping("/showIndex")
    public String showIndexAction(){
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/showMain")
    public String showMainAction(){
        return "main";
    }


    @RequestMapping("/login")
    public String loginAction(){
        return "login";
    }

//    登入页面逻辑
    @RequestMapping("/loginSucc")
    public String loginSuccAction(@RequestParam("name") String name, @RequestParam("password") String pwd, HttpServletRequest request){
        if("mirror".equalsIgnoreCase(name) && "123".equalsIgnoreCase(pwd)){
            request.getSession().setAttribute("user",name);
            return "main";
        }else {
            request.setAttribute("msg","登入失败");
            return "login";
        }
    }
}
