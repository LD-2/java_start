package com.mirror.controller;

import com.mirror.mapper.UserMapper;
import com.mirror.pojo.User;
import com.mirror.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin //在服务器端支持跨域放访问
@Controller
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;
    public static final int PAGE_SIZE = 5;

//    /user/selectUserPage?userName=z&userSex=男&page=null
    //这里方法的参数名如果和提交的name不一致就要用注解了@RequestParam
    //springmvc会把前端传来的数据自动转换为 方法属性的 类型
//    springmvc返回对象 会自动返回json格式的
    @RequestMapping("/selectUserPage")
    @ResponseBody
    public List<User> selectUserPage(String userName, String userSex, Integer page) {
        //根据页码计算起始行
        int startIndex = 0;
        if(page != null){
            startIndex = (page - 1) * PAGE_SIZE;
        }
        return userService.selectUserPage(userName,userSex,startIndex);
    }

    //    /user/getRowCount?userName=z&userSex=男
    @RequestMapping("/getRowCount")
    @ResponseBody
    public int getRowCount(String userName,String userSex){
        return userService.getRowCount(userName,userSex);
    }

//    /user/ deleteUserById?userId= 15968162087363060
    @RequestMapping("/deleteUserById")
    @ResponseBody
    public int deleteUserById(String userId){
        return userService.deleteUserById(userId);
    }

//    这里就会明白了 为什么后端要按照前端的提交数据写属性了  因为 提交后 返回一个类封装数据 就要name名和类的属性名一致
//    /user/createUser(参数见下面)
    @RequestMapping("/createUser")
    @ResponseBody
    public int createUser(User user){
        String userId = System.currentTimeMillis() + "";
        user.setUserId(userId);
        return userService.createUser(user);
    }
}
