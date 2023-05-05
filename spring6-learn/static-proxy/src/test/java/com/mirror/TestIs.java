package com.mirror;

import com.mirror.config.Config;
import com.mirror.proxy.OrderServiceImplProxy;
import com.mirror.proxy.OrderServiceImplProxyImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestIs {
    @Test
    public void testLaLa(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        OrderService orderServiceImpl = context.getBean("orderServiceImpl", OrderService.class);
//        System.out.println(orderServiceImpl);
//        orderServiceImpl.generate();
//        orderServiceImpl.detail();
//        orderServiceImpl.modify();
//
//        System.out.println("--------------");
//
//        OrderServiceImplProxy orderServiceImplProxy = context.getBean("orderServiceImplProxy", OrderServiceImplProxy.class);
////        System.out.println(orderServiceImplProxy);
//        orderServiceImplProxy.generate();
//        orderServiceImplProxy.detail();
//        orderServiceImplProxy.modify();

        System.out.println("--------------");
        OrderServiceImplProxyImpl orderServiceImplProxyImpl = context.getBean("orderServiceImplProxyImpl", OrderServiceImplProxyImpl.class);
        orderServiceImplProxyImpl.generate();
        orderServiceImplProxyImpl.detail();
        orderServiceImplProxyImpl.modify();
    }
}
