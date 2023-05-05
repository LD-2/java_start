package com.mirror.factory;

import com.mirror.service.UsbSell;

public class ShanDi implements UsbSell {
    @Override
    public float sell(int amount) {
        System.out.println("闪迪目标类 方法执行");
        return 35.0f;
    }
}
