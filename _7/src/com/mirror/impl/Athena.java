package com.mirror.impl;

import com.mirror.Hero;

public class Athena implements Hero {
    private final String name = "Athena";
    @Override
    public void attack() {
        System.out.println(name+": attack!!!");
    }

    @Override
    public void greet() {
        System.out.println(name+": Hello!!!");
    }

    @Override
    public void move() {
        System.out.println(name+": Go!!!");
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
