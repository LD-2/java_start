package com.mirror.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "testServlet", urlPatterns = {"/AServlet","/aServlet"},loadOnStartup = 1,initParams =@WebInitParam(name = "userName" ,value="root"))
public class AServlet extends HttpServlet {

//    public AServlet(){
//        System.out.println("AServlet无参构造方法已执行");
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String servletPath = req.getServletPath();
        writer.println("servletPath="+servletPath+"<br/>");

        ServletConfig servletConfig = this.getServletConfig();
        String servletName = servletConfig.getServletName();
        writer.println("servletName="+servletName+"<br/>");
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(name);
            writer.println("name="+name+"<br/>");
            writer.println("value="+value+"<br/>");
        }
    }
}
