package com.mirror.spring6;

import com.mirror.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testUser(){
//        System.out.println(new User());
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean1 = applicationContext.getBean("userBean", User.class);
        User userBean2 = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean1);
        System.out.println(userBean2);
        System.out.println("------------------------------------");
        User userBean21 = applicationContext.getBean("userBean2", User.class);
        User userBean22 = applicationContext.getBean("userBean2", User.class);
        System.out.println(userBean21);
        System.out.println(userBean22);

        //想一想为什么 singleton模式下会是单例对象  prototype模式下就变成了多例模式
        //通过把getBean()方法注释可以发现
        //通过测试得知，默认情况下 singleton下，Bean对象的创建是在初始化Spring上下文的时候就完成的
        //prototype，这样Spring会在每一次执行getBean()方法的时候创建Bean对象，调用几次则创建几次

    }
    @Test
    public void testCustomScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User sb1 = applicationContext.getBean("sb", User.class);
        User sb2 = applicationContext.getBean("sb", User.class);
        System.out.println(sb1);
        System.out.println(sb2);
        new Thread( new Runnable() {
            @Override
            public void run() {
                User a = applicationContext.getBean("sb", User.class);
                User b = applicationContext.getBean("sb", User.class);
                System.out.println(a);
                System.out.println(b);
            }
        }).start();
    }
}
