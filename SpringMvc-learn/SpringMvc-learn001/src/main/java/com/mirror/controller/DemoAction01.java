package com.mirror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mirror01")
public class DemoAction01 {
    @RequestMapping("/demo.action" )
    public String demo() {
        System.out.println("mirror01服务器被访问到了.......");
        return "main";
    }
}
