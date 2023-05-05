package com.mirror.demo04;

public class Parent<E> {
    private E value;
    public void setValue(E value) {
        this.value = value;
    }
    public E getValue(){
        return this.value;
    }
}
