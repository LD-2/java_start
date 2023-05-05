package com.mirror.controller;

import com.mirror.pojo.Student;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/ll")
@Controller
public class MyDateAction {
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

//    @RequestMapping("/mydate.action")
//    public String myDate(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("mydate") Date date) {
//        System.out.println(date);
//        System.out.println(sdf.format(date));
//        return "show";
//    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
    }
    @RequestMapping("/mydate.action")
    public String myDate(@RequestParam("mydate") Date date, HttpServletRequest request) {
        System.out.println(date);
        System.out.println(sdf.format(date));
        request.setAttribute("date",sdf.format(date));
        return "show";
    }

    @RequestMapping("/list.action")
    public String list(HttpServletRequest request) throws ParseException {
        Student stu1 = new Student("1",sdf.parse("2000-02-08"));
        Student stu2 = new Student("2",sdf.parse("2000-02-08"));
        Student stu3 = new Student("3",sdf.parse("2000-02-08"));
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        request.setAttribute("list",list);
        return "show";
    }
}
