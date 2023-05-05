package com.mirror.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main{
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<Integer>();
        set.add(321);
        set.add(21);
        set.add(123);
        set.add(333);
        System.out.println(set.contains(22));
        System.out.println(set.contains(21));
        System.out.println(set.remove(333));
        System.out.println(set.size());
        for(Integer integer:set) System.out.print(integer+" ");
        System.out.println();

        TreeSet<Integer> new_set=new TreeSet<Integer>();
        new_set.add(55);
        new_set.add(2);
        new_set.add(33);
        System.out.println(new_set.ceiling(1));
        System.out.println(new_set.ceiling(66));
        System.out.println(new_set.floor(22));
        System.out.println(new_set.floor(40));
    }
}
