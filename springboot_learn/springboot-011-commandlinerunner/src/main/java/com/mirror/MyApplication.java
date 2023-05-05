package com.mirror;


import com.mirror.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("容器对象创建后执行的 方法");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MyApplication.class, args);
        UserService userServiceImpl = run.getBean("userServiceImpl", UserService.class);
        userServiceImpl.Hello();
        System.out.println("容器对象生成");
    }
}
