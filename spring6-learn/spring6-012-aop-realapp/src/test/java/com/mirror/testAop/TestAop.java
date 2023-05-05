package com.mirror.testAop;

import com.mirror.config.Config6;
import com.mirror.hiz.ProductService;
import com.mirror.hiz.UserService;
import com.mirror.service.AccountService;
import com.mirror.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {
    @Test
    public void testTransaction(){


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config6.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        // 生成订单
        orderService.generate();
        // 取消订单
        orderService.cancel();
        // 转账
        accountService.transfer();
        // 取款
        accountService.withdraw();
    }


    @Test
    public void testSecurity(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config6.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        ProductService productService = applicationContext.getBean("productService", ProductService.class);
        userService.getUser();
        userService.saveUser();
        userService.deleteUser();
        userService.modifyUser();
        productService.getProduct();
        productService.saveProduct();
        productService.deleteProduct();
        productService.modifyProduct();
    }
}
