package com.mirror.demo06;

import java.util.ArrayList;
import java.util.Random;

public class ProductGetter<T> {
    private Random random=new Random();
    private ArrayList<T> arrayList=new ArrayList<>();
    private T product;
    public ProductGetter() {
    }
    public void addProduct(T t){
        arrayList.add(t);
    }
    public T getProduct(){
        return product=arrayList.get(random.nextInt(arrayList.size()));
    }

    public <E> E getProduct(ArrayList<E> arraylist){
        return arraylist.get(random.nextInt(arraylist.size()));
    }
    public <T> void printType(T t){
        System.out.println(t.getClass().getSimpleName());
    };
    public static <T,E,K> void printType(T t,E e,K k){
        System.out.println(t+"\t"+t.getClass().getSimpleName());
        System.out.println(e+"\t"+e.getClass().getSimpleName());
        System.out.println(k+"\t"+k.getClass().getSimpleName());
    }
}
