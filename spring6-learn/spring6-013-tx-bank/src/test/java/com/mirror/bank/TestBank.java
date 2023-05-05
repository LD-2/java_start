package com.mirror.bank;

import com.mirror.bank.pojo.Account;
import com.mirror.bank.service.AccountService;
import com.mirror.bank.service.impl.AccountServiceImpl1;
import com.mirror.bank.service.impl.IsolationService1;
import com.mirror.bank.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBank {
    @Test
    public void testTransfer(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        try {
            accountService.transfer("act001", "act002", 10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSave(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountServiceImpl1 act1 = applicationContext.getBean("act1", AccountServiceImpl1.class);
        try {
            act1.save(new Account("act003",22.00));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIsolation1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act005");
    }

    @Test
    public void testIsolation2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account act = new Account("act005", 1000.0);
        i2.save(act);
    }
}
