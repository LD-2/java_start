package com.mirror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherAction {

    @RequestMapping("/other.action")
    public String show0204(){
        System.out.println("0203");
        return "main";
    }
}
