package com.mirror;

import com.mirror.simpleFactory.Weapon;
import com.mirror.simpleFactory.WeaponFactory;
import org.junit.Test;

public class simpleFactoryTest {
    @Test
    public void testClient(){
        Weapon tank = WeaponFactory.get("Tank");
        tank.attack();
        Weapon fighter = WeaponFactory.get("fighter");
        fighter.attack();
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
    }
}
