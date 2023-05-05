package com.mirror.spring;

import com.mirror.spring6.bean.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Spring6Test {
    @Test
    public void testFirstSpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Object user = applicationContext.getBean("userBean");
        System.out.println(user);
//        在spring的配置文件中id是不能重名
//        Object vip = applicationContext.getBean("userBean");
//        System.out.println(vip);

//        spring是通过调用类的无参数构造方法来创建对象的，所以要想让spring给你创建对象，必须保证无参数构造方法是存在的

//        Spring是如何创建对象的呢？原理是什么？
//        dom4j解析beans.xml文件，从中获取class的全限定类名
//        通过反射机制调用无参数构造方法创建对象
//        Class clazz = Class.forName("com.powernode.spring6.bean.User");
//        Object obj = clazz.newInstance();
//        spring配置文件的名字是随意的

    }
    @Test
    public void testSpring(){
        // 初始化Spring容器上下文（解析beans.xml文件，创建所有的bean对象）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml","spring.xml");
        // 根据id获取bean对象
        Object userBean = applicationContext.getBean("userBean");
        Object vpiBean = applicationContext.getBean("vipBean");
//      根据这个输出的顺序 可以发现 初始化Spring容器上下文（解析beans.xml文件，创建所有的bean对象）
        System.out.println(userBean);
        System.out.println(vpiBean);

    }
    @Test
    public void testSpring2(){
//        在spring配置文件中配置的bean可以任意类，只要这个类不是抽象的，并且提供了无参数构造方法
//        当id不存在的时候，会出现异常
//        getBean()方法返回的类型是Object，如果访问子类的特有属性和方法时，还需要向下转型
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml","spring.xml");
        Date dateBean = applicationContext.getBean("dateBean", Date.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String format = sdf.format(dateBean);
        System.out.println(format);
    }

    @Test
    public void testSpring3(){
//        ClassPathXmlApplicationContext是从类路径中加载配置文件
//        没有在类路径中的话，需要使用FileSystemXmlApplicationContext类进行加载配置文件。
//        这种方式较少用。一般都是将配置文件放到类路径当中，这样可移植性更强
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("d:/spring6.xml");
    }

    @Test
    public void testSpring4(){
//        ApplicationContext的超级父接口BeanFactory
//        Spring容器存储bean 存java对象 从而new对象 处理对象间的关系
//        BeanFactory是Spring容器的超级接口。ApplicationContext是BeanFactory的子接口。
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        User userBean = beanFactory.getBean("userBean", User.class);
        System.out.println(userBean);
    }
    @Test
    public void testSpring5(){
        Logger logger = LoggerFactory.getLogger(Spring6Test.class);
        logger.info("我是一条日志消息");
        logger.debug("我是一条debug消息");
        logger.error("我是一条error消息");
    }
}
