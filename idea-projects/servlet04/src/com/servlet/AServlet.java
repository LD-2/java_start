package com.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
//        ServletContext servletContext = this.getServletConfig().getServletContext();
//        ServletContext servletContext1 = this.getServletContext();
//        writer.print(servletContext+"<br/>");
//        writer.print(servletContext1+"<br/>");
//        org.apache.catalina.core.ApplicationContextFacade@2634be2b

        ServletContext servletContext = this.getServletContext();
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            String initParameter = servletContext.getInitParameter(s);
            writer.print(s+" = "+ initParameter+"<br/>");
        }

        //动态获得应用上下文的根
        String contextPath = servletContext.getContextPath();
        writer.print(contextPath+"<br/>");

        //获得文件的真实路径
        String realPath = servletContext.getRealPath("web.xml");
        writer.print(realPath+"<br/>");

        //log
        //日志文件 日志文件会记录在哪里 会记录到tomcat下的logs文件中
        //但是由于这里是idea环境下的tomcat 所以会记录到idea中的tomcat的logs目录中
        servletContext.log("Hello Mirror...");


        //创建数据
        User user=new User("mirror","1392556557");
        //存数据
        servletContext.setAttribute("userOne",user);
        //取数据
        Object userOne = servletContext.getAttribute("userOne");
        writer.print(userOne);
    }
}
