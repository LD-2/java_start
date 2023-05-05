package com.mirror.service;


import org.springframework.stereotype.Service;

// 目标类
@Service()
public class OrderService {

    // 目标方法
    public void generate(){
        System.out.println("订单已生成！");
//        if (1 == 1) {
//            throw new RuntimeException("模拟异常发生");
//        }
//        通过测试得知，当发生异常之后，最终通知也会执行，因为最终通知@After会出现在finally语句块中。
//        出现异常之后，后置通知和环绕通知的结束部分不会执行。
    }
}