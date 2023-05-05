package com.mirror.factory_method;

import org.junit.Test;

public class TestLa {
    @Test
    public void test(){
        WeaponFactory factory = new GunFactory();
        Weapon weapon = factory.get();
        weapon.attack();

        WeaponFactory factory2 = new DaggerFactory();
        Weapon weapon2 = factory2.get();
        weapon2.attack();
    }
}
