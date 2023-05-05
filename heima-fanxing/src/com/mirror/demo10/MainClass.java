package com.mirror.demo10;

import java.lang.reflect.Method;

public class MainClass {
    public static void main(String[] args) {
        Erasure<Integer> t1=new Erasure<Integer>();
        Class<Erasure> erasureClass = Erasure.class;
        Class<? extends Erasure> aClass = t1.getClass();
        System.out.println(erasureClass.getSimpleName());
        System.out.println(aClass.getSimpleName());
        Method[] declaredMethods = aClass.getDeclaredMethods();
        //类型擦除  上限 下限
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName()+" : "+declaredMethod.getReturnType().getSimpleName());
        }

        //桥接方法
        System.out.println();
        System.out.println("桥接方法: ");
        InfoImpl info=new InfoImpl();
        Class<? extends InfoImpl> aClass1 = info.getClass();
        Method[] declaredMethods1 = aClass1.getDeclaredMethods();
        for (Method method : declaredMethods1) {
            System.out.println(method.getName()+" : "+method.getReturnType().getSimpleName());
        }
    }
}
