package com.mirror.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;




//通知类型
//通知类型包括：
//● 前置通知：@Before 目标方法执行之前的通知
//● 后置通知：@AfterReturning 目标方法执行之后的通知
//● 环绕通知：@Around 目标方法之前添加通知，同时目标方法执行之后添加通知。
//● 异常通知：@AfterThrowing 发生异常之后执行的通知
//● 最终通知：@After 放在finally语句块中的通知


//我们知道，业务流程当中不一定只有一个切面，
// 可能有的切面控制事务，有的记录日志，有的进行安全控制，
// 如果多个切面的话，顺序如何控制：可以使用@Order注解来标识切面类，
// 为@Order注解的value指定一个整数型的数字，数字越小，优先级越高。


//缺点是：
//● 第一：切点表达式重复写了多次，没有得到复用。
//● 第二：如果要修改切点表达式，需要修改多处，难维护。
//可以这样做：将切点表达式单独的定义出来，在需要的位置引入即可。如下：


// 切面类
@Order(2)
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.mirror.service.OrderService.*(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        // 执行目标方法。
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束");
    }
    // 这就是需要增强的代码（通知）
    //通知+切点=切面
    @Before("pointcut()")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }

    @AfterReturning("execution(* com.mirror.service.OrderService.*(..))")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }

    @AfterThrowing("execution(* com.mirror.service.OrderService.*(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }

    @After("execution(* com.mirror.service.OrderService.*(..))")
    public void afterAdvice(){
        System.out.println("最终通知 finally");
    }
}