package com.mirror.spring6;

import com.mirror.spring6.bean.*;
import com.mirror.spring6.service.CustomerService;
import com.mirror.spring6.service.OrderService;
import com.mirror.spring6.service.UserService;
import com.mirror.spring6.service.UserService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiTest {
    @Test
    public void testSetDi(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceBean = applicationContext.getBean("userServiceBean", UserService.class);
        userServiceBean.save();
        userServiceBean.save2();
    }

    @Test
    public void testSetDi2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerServiceBean1 = applicationContext.getBean("customerServiceBean1", CustomerService.class);
        customerServiceBean1.save();
        CustomerService customerServiceBean2 = applicationContext.getBean("customerServiceBean2", CustomerService.class);
        customerServiceBean2.save();
        CustomerService customerServiceBean3 = applicationContext.getBean("customerServiceBean3", CustomerService.class);
        customerServiceBean3.save();
    }

    @Test
    public void testSetDi3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderServiceBean1 = applicationContext.getBean("orderServiceBean1", OrderService.class);
        orderServiceBean1.save();
        OrderService orderServiceBean2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderServiceBean2.save();
    }

    @Test
    public void testSimpleTypeSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User user = applicationContext.getBean("User", User.class);
        System.out.println(user);
    }

    @Test
    public void testDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-datasource.xml");
        MyDataSource dataSource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testAllSimpleType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-all-simple-type.xml");
        A a = applicationContext.getBean("a", A.class);
        System.out.println(a);
    }

    @Test
    public void testCascade(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-cascade.xml");
        Student student = applicationContext.getBean("StudentBean", Student.class);
        System.out.println(student);
    }

    @Test
    public void testArraySimple(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array-simple.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    @Test
    public void testArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        System.out.println(orderBean);
    }

    @Test
    public void testCollection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    @Test
    public void testNull(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-null.xml");
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
        Vip vipBean2 = applicationContext.getBean("vipBean2", Vip.class);
        System.out.println(vipBean2);
        Vip vipBean3 = applicationContext.getBean("vipBean3", Vip.class);
        System.out.println(vipBean3);
    }

    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Customer customerBean = applicationContext.getBean("customerBean", Customer.class);
        System.out.println(customerBean);
    }

    @Test
    public void testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        MyTime myTimeBean = applicationContext.getBean("myTimeBean", MyTime.class);
        System.out.println(myTimeBean);
    }

    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");

        MyDataSource1 dataSource1 = applicationContext.getBean("dataSource1", MyDataSource1.class);
        System.out.println(dataSource1);

        MyDataSource2 dataSource2 = applicationContext.getBean("dataSource2", MyDataSource2.class);
        System.out.println(dataSource2);
    }

    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource dataSource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);
    }
    @Test
    public void testAutowireByName(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserService2 userService2 = applicationContext.getBean("userService", UserService2.class);
        userService2.save();
    }


}
