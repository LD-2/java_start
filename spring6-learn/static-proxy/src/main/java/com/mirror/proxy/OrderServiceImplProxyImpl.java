package com.mirror.proxy;

import com.mirror.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;


//这种方式的优点：符合OCP开闭原则，同时采用的是关联关系，所以程序的耦合度较低。所以这种方案是被推荐的。
@Component
public class OrderServiceImplProxyImpl implements OrderService {

    @Resource(name = "orderServiceImpl")
    private OrderService orderService;

    @Override
    public void generate() {
        long start = System.currentTimeMillis();
        orderService.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(start-end)+"毫秒");
    }

    @Override
    public void detail() {
        long start = System.currentTimeMillis();
        orderService.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(start-end)+"毫秒");
    }

    @Override
    public void modify() {
        long start = System.currentTimeMillis();
        orderService.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(start-end)+"毫秒");
    }
}
