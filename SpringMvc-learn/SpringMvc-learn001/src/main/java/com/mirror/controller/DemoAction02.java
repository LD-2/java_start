package com.mirror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mirror02")
public class DemoAction02 {
    @RequestMapping("/demo.action" )
    public String demo() {
        System.out.println("mirror02服务器被访问到了.......");
        return "main";
    }
}
