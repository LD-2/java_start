package com.mirror.test;

import com.mirror.myspringframework.ApplicationContext;
import com.mirror.myspringframework.ClassPathXmlApplicationContext;
import org.junit.Test;

public class Testlal {
    @Test
    public void testla(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object userBean = applicationContext.getBean("userBean");
        Object addrBean = applicationContext.getBean("addrBean");
        System.out.println(userBean);
        System.out.println(addrBean);
    }
}
