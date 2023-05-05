package com.mirror.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//必须实现InvocationHandler接口，完成代理类要做的功能（1、调用目标方法 2、功能增强）
public class MySellHandler implements InvocationHandler {

    private Object target = null;
    //动态代理：目标对象是动态的
    //传入谁就给谁创建代理
    public MySellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res=null;
        //执行目标方法
        res = method.invoke(target, args);

        //增加的功能
        if(res!=null){
            float price = (float)res;
            price = price + 20;
            res=price;
        }
        System.out.println("淘宝商家返回了优惠卷");
        //增加后的价格
        return res;
    }
}
