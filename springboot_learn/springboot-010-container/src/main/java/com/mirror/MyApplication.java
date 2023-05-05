package com.mirror;

import com.mirror.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MyApplication.class, args);
//        ApplicationContext    ConfigurableApplicationContext
        UserService userServiceImpl = run.getBean("userServiceImpl", UserService.class);
        System.out.println(userServiceImpl);
        userServiceImpl.Hello();
    }
}
