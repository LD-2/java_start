package com.mirror.demo05;

public class Test01 implements Inter<String>{
    private String value;

    public Test01(String value) {
        this.value = value;
    }

    public Test01() {
    }

    @Override
    public String getValue() {
        return value;
    }
}
