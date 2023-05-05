package com.mirror.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Scanner sc=new Scanner(System.in);
        while (map.size()<3){
            map.put(sc.nextInt(),sc.nextInt());
        }
        System.out.println(map.entrySet());
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.printf("%d %d   ",entry.getKey(),entry.getValue());
        }
        System.out.println();
        Map.Entry<Integer,Integer> up=map.ceilingEntry(6);
        System.out.println(up);
    }
}
