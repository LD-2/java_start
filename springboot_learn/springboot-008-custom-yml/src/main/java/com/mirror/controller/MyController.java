package com.mirror.controller;


import com.mirror.bean.StudentInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {


    @Value("${school.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @Value("${school.address}")
    private String address;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "name = " + name + ", address =" +address + ", port = " + port;
    }


    @Resource
    private StudentInfo studentInfo;

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(){
        return studentInfo.getName()+studentInfo.getAddress();
    }
}
