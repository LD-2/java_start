package com.mirror.demo08;

import java.util.ArrayList;

public class TestDown {
    public static void main(String[] args) {
        ArrayList<Cat>cats = new ArrayList<Cat>();
        ArrayList<MinCat>minCats=new ArrayList<MinCat>();
        ArrayList<Animal>animals = new ArrayList<Animal>();
        showAnimals(cats);
//        showAnimals(minCats);
        showAnimals(animals);
    }

    public static void showAnimals(ArrayList<? super Cat>list){
        list.add(new MinCat());
        list.add(new Cat());
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
