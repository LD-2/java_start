package com.mirror.list;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<Integer>();
        list.add(8);
        list.add(11);
        list.add(6);
        for(Integer integer:list) System.out.print(integer+" ");
        System.out.println();
        list.clear();
        System.out.println(list.isEmpty()?"空":"非空");
        list.add(9);
        list.add(7);
        list.add(12);
        System.out.println(list.isEmpty()?"空":"非空");
        for(int i=0;i<list.size();i++)System.out.print(list.get(i)+" ");
        System.out.println();
    }
}
