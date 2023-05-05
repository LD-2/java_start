package com.mirror.controller;

import com.mirror.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentListAction {
    @RequestMapping("/list")
    @ResponseBody//系欸小ajx请求必须要在springmvc中加载此注解驱动
    public List<Student> list(){
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("mirror",23));
        list.add(new Student("ld",22));
        return list;//这里springmvc自动转成了json对象 因为返回类型是Object
    }
}
