package com.mirror.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class YourAspect {

    @Before("execution(* com.mirror.service.OrderService.generate())")
    public void advice(){
        System.out.println("当然是前置通知了  6 没有的 仍然用后面的");
    }

}
