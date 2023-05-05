package com.mirror.demo03;

import java.util.ArrayList;
import java.util.Random;

public class ProductGetter<T> {
    Random random=new Random();
    private T product;
    ArrayList<T> products =new ArrayList<>();
    public void addProduct(T t){
        products.add(t);
    }
    public T getProduct(){
        return product=products.get(random.nextInt(products.size()));
    }

}
