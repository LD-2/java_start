package com.mirror;

import com.mirror.pojo.User;
import com.mirror.service.UserService;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//启动spring容器
@ContextConfiguration("classpath:spring.xml")
public class TestProject {

    @Resource
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> lists = userService.selectUserPage("", "", 0);
        lists.forEach(list-> System.out.println(list));
    }

    @Test
    public void testCreateUse(){
        System.out.println(userService.createUser(new User("123","拉拉证","11321","hahe","nv","20","player")));
    }

    @Test
    public void testDeleteUserById(){
        System.out.println(userService.deleteUserById("123"));
    }

    @Test
    public void testGetRowCount(){
        System.out.println(userService.getRowCount("", "女"));
    }
}
