package com.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
/*
* ServletContext接口是Servlet规范之一
* ServletContext接口由服务器（tomcat）实现
* ServletConfig中可以调用ServletContext
* class org.apache.catalina.core.ApplicationContextFacade
* 根据类的路径和哈希值
* 一个servletConfig对应一个servlet对象
* 一个servletContext对应一个web.xml文件
* 对于一个webapp来说servletContext文件只有一个 服务器开启时创建 关闭时销毁
* servletContext中的数据是被servletConfig共享的
*
* Tomcat是一个容器 一个容器中可以放多个Webapp 一个webapp对应一个servletContext 一个servlet对象对应一个servletConfig
*
*
*/


public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
//        writer.print(servletResponse.toString()+"<br/>");
//        writer.print(servletResponse.getClass()+"<br/>");
//        writer.print(this.getServletContext());
        //org.apache.catalina.core.ApplicationContextFacade@2634be2b
        //org.apache.catalina.core.ApplicationContextFacade@2634be2b


        //取数据
        Object userOne = this.getServletContext().getAttribute("userOne");
        writer.print(userOne);
    }
}
