package com.mirror.shangjia;

import com.mirror.factory.UsbKingFactory;
import com.mirror.service.UsbSell;

//淘宝是一个代理
public class TaoBao implements UsbSell {
    private UsbSell usbKingFactory = new UsbKingFactory();
    @Override
    public float sell(int amount) {
        float price = usbKingFactory.sell(amount);
        //代理增加的功能 就是目标类执行完此函数后的内容
        System.out.println("商家返回了优惠卷");
        price+=30;
        return price;
    }
}
