package com.servlet;

import jakarta.servlet.*;

import java.io.IOException;
/*
* 这里tomcat执行的是有参数的init方法
* 这个参数肯定会在getServletConfig中使用在service 中也会使用
* 因此这个tomcat创建的ServletConfig实例对象 在GenericServlet中应该是一个私有的成员变量
* 那么适配器类继承了GenericServlet可能也会重写init函数那么为了保证私有变量还可以用 这里就重载一个init方法 重写init方法并且在有参数的init方法中执行
*
* 具体也可以看servlet规范实现的GenericServlet类
*
*/
public abstract class GenericServlet implements Servlet {
    private ServletConfig servletConfig;
    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig=servletConfig;
        System.out.println("init(servletConfig)");
        this.init();
    }
    public void init(){

    }
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
