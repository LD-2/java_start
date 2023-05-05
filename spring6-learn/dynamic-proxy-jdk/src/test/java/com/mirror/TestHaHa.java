package com.mirror;

import com.mirror.config.Config;
import com.mirror.handler.TimerInvocationHandler;
import com.mirror.service.OrderService;
import com.mirror.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class TestHaHa {
    @Test
    public void testHaHa() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        OrderServiceImpl orderServiceImpl = context.getBean("orderServiceImpl", OrderServiceImpl.class);
        orderServiceImpl.detail();
    }

    @Test
    public void testClient(){
//        第一步 创建目标对象
        OrderService target = new OrderServiceImpl();
//        第二步 创建代理对象
        OrderService orderServiceProxy = (OrderService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));
//        第三步 调用代理对象的代理方法
        orderServiceProxy.generate();
        orderServiceProxy.detail();
        orderServiceProxy.modify();
//        以上第二步创建代理对象是需要大家理解的：
//OrderService orderServiceProxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), 调用处理器对象);
//这行代码做了两件事：
//● 第一件事：在内存中生成了代理类的字节码
//● 第二件事：创建代理对象
//Proxy类全名：java.lang.reflect.Proxy。这是JDK提供的一个类（所以称为JDK动态代理）。主要是通过这个类在内存中生成代理类的字节码。
//其中newProxyInstance()方法有三个参数：
//● 第一个参数：类加载器。在内存中生成了字节码，要想执行这个字节码，也是需要先把这个字节码加载到内存当中的。所以要指定使用哪个类加载器加载。
//● 第二个参数：接口类型。代理类和目标类实现相同的接口，所以要通过这个参数告诉JDK动态代理生成的类要实现哪些接口。
//● 第三个参数：调用处理器。这是一个JDK动态代理规定的接口，接口全名：java.lang.reflect.InvocationHandler。显然这是一个回调接口，也就是说调用这个接口中方法的程序已经写好了，就差这个接口的实现类了。
//所以接下来我们要写一下java.lang.reflect.InvocationHandler接口的实现类，并且实现接口中的方法



//        大家可能会比较好奇：那个InvocationHandler接口中的invoke()方法没看见在哪里调用呀？
//        注意：当你调用代理对象的代理方法的时候，
//        注册在InvocationHandler接口中的invoke()方法会被调用。
//        也就是上面代码第30 31 32行，这三行代码中任意一行代码执行，
//        注册在InvocationHandler接口中的invoke()方法都会被调用
//        学到这里可能会感觉有点懵，折腾半天，到最后这不是还得写一个接口的实现类吗？没省劲儿呀？
//        你要这样想就错了!!!!
//        我们可以看到，不管你有多少个Service接口，多少个业务类，这个TimerInvocationHandler接口是不是只需要写一次就行了，代码是不是得到复用了！！！！
//        而且最重要的是，以后程序员只需要关注核心业务的编写了，像这种统计时间的代码根本不需要关注。因为这种统计时间的代码只需要在调用处理器中编写一次即可。
//        到这里，JDK动态代理的原理就结束了。
    }

}
