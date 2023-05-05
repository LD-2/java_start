package com.mirror.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;


public class MyServletRequestListenerTest implements ServletRequestListener {

    //ServletRequest对象创建时间点
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequest对象销毁了");
    }


    //ServletRequest创建时间点
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequest对象创建了");
    }
}
