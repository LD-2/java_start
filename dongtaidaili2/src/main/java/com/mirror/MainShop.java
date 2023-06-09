package com.mirror;

import com.mirror.factory.UsbKingFactory;
import com.mirror.handler.MySellHandler;
import com.mirror.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainShop {
    public static void main(String[] args) {

        //创建目标对象
        UsbSell factory=new UsbKingFactory();
        //创建InvocationHandle对象
        InvocationHandler handle=new MySellHandler(factory);
        //创建代理对象
        UsbSell proxy=(UsbSell)Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(),handle);
        //通过代理对象可以执行方法
        float price=proxy.sell(1);
        System.out.println("通过动态代理调用方法");
    }
}
