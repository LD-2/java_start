package com.mirror.annotation;

import com.mirror.annotation.bean.People;
import com.mirror.annotation.bean.User;
import com.mirror.annotation.bean.Vip;
import com.mirror.annotation.bean2.Order;
import com.mirror.annotation.config.Spring6Config;
import com.mirror.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class Test2 {
    @Test
    public void testAnnotation() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
//        User user = applicationContext.getBean("user", User.class);
        System.out.println(userBean);
//        System.out.println(user);
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
        People people = applicationContext.getBean("people",People.class);
        System.out.println(people);
        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        System.out.println(orderBean);
    }

    @Test
    public void testChoose(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");
        Object a = applicationContext.getBean("b");
        System.out.println(a);
    }

    @Test
    public void testAnnotation2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-zhuru.xml");
        com.mirror.annotation.bean4.User user = applicationContext.getBean("user",com.mirror.annotation.bean4.User.class);
        System.out.println(user);

    }

    @Test
    public void testAnnotation3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-zhuru.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.save();
    }

    @Test
    public void testAnnotation4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springzhuru2.xml");
        com.mirror.annotation.service2.UserService bean = applicationContext.getBean("userService",com.mirror.annotation.service2.UserService.class);
        bean.save();
    }

    @Test
    public void testConfig(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        com.mirror.annotation.bean.User user = annotationConfigApplicationContext.getBean("userBean", com.mirror.annotation.bean.User.class);
        System.out.println(user);
    }
}
