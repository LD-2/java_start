package com.mirror.spring6.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInstantiation {

    @Test
    public void testInstantiation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User sb = applicationContext.getBean("sb", User.class);
        System.out.println(sb);
    }

    @Test
    public void testInstantiation2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
    }

    @Test
    public void testDate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        Student student = applicationContext.getBean("studentBean", Student.class);
        System.out.println(student);
    }

    @Test
    public void testGetDate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

}
