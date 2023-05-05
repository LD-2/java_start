package com.mirror.demo03;

public class MainClass {
    public static void main(String[] args) {
        ProductGetter<String> productGetter = new ProductGetter<>();
        String[] products=new String[]{"a","b","c","d"};
        for(String product : products){
            productGetter.addProduct(product);
        }
        System.out.println(productGetter.getProduct());
    }
}
