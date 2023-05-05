package com.mirror.proxy;

import com.mirror.impl.OrderServiceImpl;
import org.springframework.stereotype.Component;



//项目已上线，并且运行正常，只是客户反馈系统有一些地方运行较慢，要求项目组对系统进行优化。
//于是项目负责人就下达了这个需求。首先需要搞清楚是哪些业务方法耗时较长，于是让我们统计每个业务方法所耗费的时长。
//如果是你，你该怎么做呢？
//第一种方案：直接修改Java源代码，在每个业务方法中添加统计逻辑
//需求可以满足，但显然是违背了OCP开闭原则。这种方案不可取。
//第二种方案：编写一个子类继承OrderServiceImpl，在子类中重写每个方法
//这种方式可以解决，但是存在两个问题：
//● 第一个问题：假设系统中有100个这样的业务类，需要提供100个子类，并且之前写好的创建Service对象的代码，都要修改为创建子类对象。
//● 第二个问题：由于采用了继承的方式，导致代码之间的耦合度较高。
//这种方案也不可取。
//第三种方案：使用代理模式（这里采用静态代理）
//可以为OrderService接口提供一个代理类
//以上就是代理模式中的静态代理，其中OrderService接口是代理类和目标类的共同接口。OrderServiceImpl是目标类。OrderServiceProxy是代理类。
//这种方式的优点：符合OCP开闭原则，同时采用的是关联关系，所以程序的耦合度较低。所以这种方案是被推荐的。
//大家思考一下：如果系统中业务接口很多，一个接口对应一个代理类，
// 显然也是不合理的，会导致类爆炸。
// 怎么解决这个问题？动态代理可以解决。
// 因为在动态代理中可以在内存中动态的为我们生成代理类的字节码。
// 代理类不需要我们写了。类爆炸解决了，而且代码只需要写一次，代码也会得到复用。
@Component
public class OrderServiceImplProxy extends OrderServiceImpl {
    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        super.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+ (end - begin) + "毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        super.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+ (end - begin) + "毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        super.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+ (end - begin) + "毫秒");
    }
}
