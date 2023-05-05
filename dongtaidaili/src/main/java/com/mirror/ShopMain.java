package com.mirror;

import com.mirror.service.UsbSell;
import com.mirror.shangjia.TaoBao;
import com.mirror.shangjia.WeiShang;

public class ShopMain {
    public static void main(String[] args) {
        UsbSell taoBao=new TaoBao();
        taoBao.sell(1);
        System.out.println("淘宝商家售卖");

        UsbSell weishang=new WeiShang();
        weishang.sell(1);
        System.out.println("微商商家售卖");
    }

}
