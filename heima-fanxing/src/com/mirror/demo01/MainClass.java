package com.mirror.demo01;

import java.util.ArrayList;
import java.util.Objects;

public class MainClass {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("java");
        arrayList.add(100);
        arrayList.add(true);
        for(int i=0;i<arrayList.size();i++){
            Object o=arrayList.get(i);
//            String str=(String)o;
            System.out.println(o.getClass());
            System.out.println(o);
            System.out.println(arrayList.get(i));
        }

        //泛型的引入  提示ClassCastException异常 直接指定数据类型不用数据转换  编译器检查数据类型
        System.out.println();
        System.out.println("泛型的引入: ");

    }
}
