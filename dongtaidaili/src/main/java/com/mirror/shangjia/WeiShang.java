package com.mirror.shangjia;

import com.mirror.factory.UsbKingFactory;
import com.mirror.service.UsbSell;

public class WeiShang implements UsbSell {
    private UsbSell usbKingFactory=new UsbKingFactory();
    @Override
    public float sell(int amount) {
        float price = usbKingFactory.sell(1);
        System.out.println("微商卖 多一元");
        return price+1;
    }
}
