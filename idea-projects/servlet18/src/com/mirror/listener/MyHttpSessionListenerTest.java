package com.mirror.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;



@WebListener
public class MyHttpSessionListenerTest implements HttpSessionListener {

    //session对象是什么时候被自动创建的
    //是在 jsp九大内置对象中被创建的（默认创建的 true）(或者通过request的getSession方法创建)
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("HttpSession对象被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("HttpSession对象被销毁");
    }
}
