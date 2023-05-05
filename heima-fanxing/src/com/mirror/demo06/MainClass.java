package com.mirror.demo06;

public class MainClass {
    public static void main(String[] args) {
        ProductGetter<String> productGetter = new ProductGetter<>();
        productGetter.printType("mirror");
        ProductGetter.printType("3213",213123,213);

    }
}
