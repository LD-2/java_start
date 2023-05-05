package com.mirror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Show {
    @RequestMapping("/show01.action")
    public String show01(){
        System.out.println("请求转发页面（默认）");
        return "main";
    }

    @RequestMapping("/show02.action")
    public String show02(){
        System.out.println("请求转发action");
//        forward可以屏蔽前缀 后缀的拼接
        return "forward:/other.action";
    }

    @RequestMapping("/show03.action")
    public String show03(){
        System.out.println("跳转页面");
//        forward可以屏蔽前缀 后缀的拼接
        return "redirect:/other.action";
    }

    @RequestMapping("/show04.action")
    public String show04(){
        System.out.println("跳转页面");
//        forward可以屏蔽前缀 后缀的拼接
        return "redirect:/mirror/main.jsp";
    }
}
