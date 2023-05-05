package com.mirror.simpleFactory;

public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("战斗机出击");
    }
}
