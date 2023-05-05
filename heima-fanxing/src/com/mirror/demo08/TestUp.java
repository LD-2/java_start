package com.mirror.demo08;

import java.util.ArrayList;

public class TestUp {
    public static void main(String[] args) {
        ArrayList<Animal>animals=new ArrayList<Animal>();
        ArrayList<Cat> cats=new ArrayList<Cat>();
        ArrayList<MinCat>minCats=new ArrayList<MinCat>();
        showAnimal(cats);
        showAnimal(minCats);
//        showAnimal(animals);
    }
    public static void showAnimal(ArrayList<?extends Cat>list) {
//        list.add(new Cat());
        for(int i=0;i< list.size();i++){
            System.out.println(list.get(i));
        }
    }

}
