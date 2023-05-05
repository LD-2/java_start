package com.mirror.controller;

import com.mirror.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReqAction {

    @RequestMapping(value = "/req.ld",method = RequestMethod.GET)
    public String reqGet(){
        System.out.println("处理get的");
        return "first";
    }
    @RequestMapping(value = "/req.ld",method = RequestMethod.POST)
    public String reqPost(){
        System.out.println("处理post请求");
        return "first";
    }

    @RequestMapping(value = "/req01.ld",method = RequestMethod.POST)
    public String reqPost01(String uname , int age){
        System.out.println(uname+" "+age);
        return "first";
    }

    @RequestMapping(value = "/req02.ld",method = RequestMethod.POST)
    public String reqPost02(User u){
        System.out.println(u);
        return "first";
    }

    @RequestMapping(value = "/req03/{name}/{age}.ld")
    public String reqPost03(@PathVariable String name ,@PathVariable int age){
        System.out.println(name +" "+ age);
        return "first";
    }

    @RequestMapping ("/req04.ld")
    public String reqPost04(@RequestParam("name")String uname,@RequestParam("age")int uage) {
        System.out.println("uname=" + uname + ", uage=" + (uage + 100));
        return "first";
    }

    @RequestMapping ("/req05.ld")
    public String reqPost05(HttpServletRequest request) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println(name +  " " + (age+100));
        return "first";
    }
}
