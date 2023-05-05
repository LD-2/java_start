package com.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
/*
* ServletConfig
*   1、ServletConfig是什么
*       jakarta.servlet.ServletConfig
*       其实servlet规范中的一员  是一个接口
*   2、谁实现这个类
*       tomcat创建了这个实现类的对象
*       public class org.apache.catalina.core.StandardWrapperFacade implements ServletConfig{}
*       因此tomcat实现了这个接口
*       各个不同的服务器软件都会实现这个接口 只不过是包名类名可能不一样 但是规范是一样的
*   3、
*       一个servlet对象对应一个servletConfig信息
*       ServletConfig接口的实现类及其对象org.apache.catalina.core.StandardWrapperFacade@7468f884
*       ServletConfig的实现类及其对象org.apache.catalina.core.StandardWrapperFacade@412cda3e
*   4、servletConfig是谁创建的
*       Tomcat服务器创建的
*       在创建了Servlet对象的时候 同时创建ServletConfig对象
*   5、ServletConfig接口的作用
*       ServletConfig对象对应的是Servlet对象的配置信息
*       每个servlet对象就对应一个servletConfig对象配置信息
*   6、ServletConfig对象中包装的信息
*       包装的是web.xml文件中的<servlet></servlet>配置中的信息
*   7、ServletConfig接口 中的四个方法
*       public Enumeration<String> initParameterNames();
*       public String getInitParameter(String name);
*       public String getServletName();
*       public servletContext getServletContext();
*/

public class ConfigServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        ServletConfig servletConfig = this.getServletConfig();
        //servletConfig对象是tomcat创建的 通过这种方式查看其接口实现类
        writer.print("ServletConfig接口的实现类及其对象"+servletConfig);
        //输出引用就是输出此类对象的toString()方法

        writer.print("<br/>");
        //输出ServletConfig中的配置信息
        String servletName = servletConfig.getServletName();
        writer.print("<servlet>"+servletName+"<servlet>");
        writer.print("<br/>");
        //通过ServletConfig对象的两个方法可以获得web.xml中的初始化信息
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            String initParameter = servletConfig.getInitParameter(s);
            writer.print(s+" = "+initParameter);
            writer.print("<br/>");
        }

        //可以看内部实现方法 还是调用config
        Enumeration<String> initParameterNames1 = this.getInitParameterNames();
        while(initParameterNames1.hasMoreElements()){
            String s = initParameterNames1.nextElement();
            String initParameter = this.getInitParameter(s);
            writer.print(initParameter);
            writer.print("<br/>");
        }
        

    }
}
