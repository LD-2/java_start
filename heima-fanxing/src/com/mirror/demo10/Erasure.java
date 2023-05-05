package com.mirror.demo10;

import java.util.List;

public class Erasure<T extends Number> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public <T extends List>T show(T t){
        return t;
    }
}
