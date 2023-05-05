package com.mirror.factory;

import com.mirror.service.UsbSell;

public class UsbKingFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        System.out.println("目标类中方法调用");
        //返回单价
        return 22.0f;
    }
}
