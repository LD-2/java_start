package com.mirror.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListenerTest implements HttpSessionAttributeListener {

    //在Session域添加数据的时候 服务器使得监听器对象执行此方法
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session域 添加数据..");
    }

    //在Session域删除数据的时候  此方法被Web服务器调用
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session域 删除数据..");
    }

    //在Session域替换数据的时候  此方法被Web服务器调用
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session域 替换数据..");
    }
}
