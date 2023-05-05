package com.mirror.controller;

import com.mirror.model.Student;
import com.mirror.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/student/query")
    @ResponseBody
    public String queryStudent(Integer id){
        Student student = studentService.queryStudent(id);
        return student.toString();
    }


    @RequestMapping("/test")
    @ResponseBody
    public String test(String name,int age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return studentService.insertStudent(student)+"插入成功了";
    }
}
