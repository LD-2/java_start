package com.mirror.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;



/*
    监听器中的方法不需要程序员手动调用 是发生在某个特殊事件之后被服务器调用的
*/
@WebListener
public class MyServletContextListenerTest implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) { //服务器启动的时间点 想在这个时间点执行一段代码 写就欧克了
        // 现在这个特殊的时刻写代码 你写就是了 它会被服务器自动调用
        // 这个方法是在ServletContext对象被创建时调用的
        System.out.println("ServletContext对象创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) { //服务器关闭的时间点 想在这个时间点执行一段代码 写就欧克了
        // 在这个特殊时刻写代码 写了就会被调用
        // 这个方法是在SevletContext对象被销毁的时候调用的
        System.out.println("ServletContext对象销毁了");
    }
}
