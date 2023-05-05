package com.mirror.simpleFactory;

public class Tank extends Weapon{
    @Override
    public void attack() {
        System.out.println("Tank出击");
    }
}
