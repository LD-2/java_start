package com.mirror.shangjia;

import com.mirror.factory.ShanDi;
import com.mirror.service.UsbSell;

public class TaoBaoShanDi implements UsbSell {
    private UsbSell shanDi=new ShanDi();
    @Override
    public float sell(int amount) {
        float price = shanDi.sell(1);
        return price+20;
    }
}
