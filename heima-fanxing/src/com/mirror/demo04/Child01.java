package com.mirror.demo04;

public class Child01<T> extends Parent<T> {
    private T value;
    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
