package com.mirror.bank;

import com.mirror.bank.service.AccountService;
import com.mirror.bank.service.impl.AccountServiceImpl;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestSM {
    @Resource(name = "accountServiceImpl")
    private AccountService accountService;
    @Test
    public void testSM(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        try {
            accountService.transfer("act001", "act002", 10000.0);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }
}
