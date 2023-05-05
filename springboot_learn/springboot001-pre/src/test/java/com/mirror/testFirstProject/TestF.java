package com.mirror.testFirstProject;

import com.mirror.config.SpringConfig;
import com.mirror.vo.Cat;
import com.mirror.vo.Student;
import com.mirror.vo.Tiger;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.zip.DataFormatException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestF {
    @Autowired
//    @Resource(name = "myStudent02")不可以 用junit4引入对象吗
    private Student student;
    @Autowired
    private Cat cat;
    @Test
    public void testStudent() {
        System.out.println(student);
        System.out.println(cat);
    }

    /**
     * 注意如果没有用junit4的时候 要用test就要用
     * ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
     */
    @Test
    public void testStudent02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student myStudent02 = applicationContext.getBean("myStudent02", Student.class);
        System.out.println(myStudent02);
        Student createStudent = applicationContext.getBean("createStudent", Student.class);
        System.out.println(createStudent);
        Date myDate = applicationContext.getBean("myDate", Date.class);
        System.out.println(myDate);


        System.out.println("-----测试ImportResource 导入外部xml-----");
        Cat myCat = applicationContext.getBean("myCat", Cat.class);
        System.out.println(myCat);
        Student myStudent01 = applicationContext.getBean("myStudent01", Student.class);
        System.out.println(myStudent01);


        System.out.println("-----测试properties -> Tiger-----");
        System.out.println(applicationContext.getBean("tiger", Tiger.class));
    }


}
