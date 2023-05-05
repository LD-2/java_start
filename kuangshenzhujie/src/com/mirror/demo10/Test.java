package com.mirror.demo10;

import com.mirror.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//分析性能问题
public class Test {
    public static void test01(){
        User u=new User();
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            u.getName();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("普通的方法 "+(endTime-startTime));
    }
    public static void test02() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class c1 = User.class;
        User u=(User)c1.newInstance();
        Method method = c1.getMethod("getName",null);
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            method.invoke(u);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("反射方式调用 "+(endTime-startTime));
    }
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u=new User();
        Class c1=u.getClass();
        Method method=c1.getMethod("getName",null);
        method.setAccessible(true);
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            method.invoke(u);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("反射方式调用 关闭安全检测 "+(endTime-startTime));
    }
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //普通方式调用
        test01();
        test02();
        test03();
    }
}
