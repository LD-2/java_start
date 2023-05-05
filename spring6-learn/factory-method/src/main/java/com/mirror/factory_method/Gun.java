package com.mirror.factory_method;

public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("Gun出击..");
    }
}
