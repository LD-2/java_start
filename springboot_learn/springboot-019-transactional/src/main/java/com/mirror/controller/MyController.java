package com.mirror.controller;

import com.mirror.model.Student;
import com.mirror.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(int id,String name,int age){
        Student student = new Student();
        student.setId(2);
        student.setName("ld");
        student.setAge(20);
        return studentService.insertStudent(student)+"插入成功了";
    }
}
