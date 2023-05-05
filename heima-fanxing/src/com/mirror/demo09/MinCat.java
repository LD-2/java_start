package com.mirror.demo09;

public class MinCat extends Cat{
    private int level;

    public MinCat() {
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return super.toString()+" level= "+level;
    }

    public MinCat(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }
}
