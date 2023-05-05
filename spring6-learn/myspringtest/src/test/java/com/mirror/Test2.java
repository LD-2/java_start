package com.mirror;

//import com.mirror.myspringframework.ApplicationContext;

import com.mirror.myspringframework.ApplicationContext;
import com.mirror.myspringframework.ClassPathXmlApplicationContext;
import org.junit.Test;



public class Test2 {
    @Test
    public void testMySpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceBean = (UserService) applicationContext.getBean("userServiceBean");
        userServiceBean.save();
    }
}
