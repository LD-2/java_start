package com.mirror.demo09;

import java.util.Comparator;
import java.util.TreeSet;

public class MainClass {
    public static void main(String[] args) {
//        TreeSet<Cat> treeSet = new TreeSet<Cat>(new Comparator1());
//        TreeSet<Cat> treeSet = new TreeSet<Cat>(new Comparator2());
        TreeSet<Cat> treeSet = new TreeSet<Cat>(new Comparator3());
        treeSet.add(new Cat("lala",22));
        treeSet.add(new Cat("didi",23));
        treeSet.add(new Cat("bibi",24));
        for (Cat cat : treeSet) {
            System.out.println(cat.toString());
        }
    }
}

class Comparator1 implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getAge() - o2.getAge();
    }
}
class Comparator2 implements Comparator<MinCat>{
    @Override
    public int compare(MinCat o1, MinCat o2) {
        return o1.getLevel()-o2.getLevel();
    }
}
class Comparator3 implements Comparator<Animal>{
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
