package com.mirror.demo05;

public class Pair<T,E> implements Inter<T>{
    private T value;
    private E key;

    @Override
    public T getValue() {
        return this.value;
    }
    public E getKey(){
        return this.key;
    }
    public Pair(T value, E key) {
        this.value = value;
        this.key = key;
    }
    public Pair() {
    }
}
