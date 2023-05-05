package com.mirror.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {


    @RequestMapping("/test")
//这里的HttpServletRequest request  和  Model model
//    request.setAttr..   和  model.addAttribute("data","SpringBoot 前端使用 JSP) 一样的用法
    public String test(Model model) {
        model.addAttribute("data","传入的data数据");
        return "index";
        //这里还要配置视图解析器  原来在 springmvc.xml文件中配置 现在在 boot配置文件中配置
    }

}
