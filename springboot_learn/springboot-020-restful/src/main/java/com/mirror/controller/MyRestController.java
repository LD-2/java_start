package com.mirror.controller;


import org.springframework.web.bind.annotation.*;


//RestController  包含这两个 @Controller  @ResponseBody注解 是一个复合注解
@RestController
public class MyRestController {


//    {stuId}  定义路径变量
    @GetMapping("/student/{stuId}")
    public String queryStudent(@PathVariable("stuId") Integer studentId){
        return "查询学生id + " + studentId;
    }

    @PostMapping("/student/{name}/{age}")
    public String creatStudent(@PathVariable("name") String name, @PathVariable("age") Integer age){
        return "name: " + name + ", age: " + age;
    }

    //更新
    @PutMapping()


    //删除
    @DeleteMapping()
}
