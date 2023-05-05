package com.mirror.factory;

import com.mirror.service.UsbSell;
//目标类
public class UsbKingFactory implements UsbSell {

    //目标方法
    @Override
    public float sell(int amount) {
        System.out.println("执行了目标类中的目标方法sell");
        return 22.0f;
    }
}
