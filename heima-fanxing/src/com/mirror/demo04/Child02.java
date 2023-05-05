package com.mirror.demo04;

public class Child02 extends Parent<String> {
    private String value;

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
