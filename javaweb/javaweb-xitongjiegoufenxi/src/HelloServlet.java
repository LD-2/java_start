package com.mirror.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
public class HelloServlet implements Servlet{
    public void init(ServletConfig config) throws ServletException{

    }
    public ServletConfig getServletConfig(){
        return null;
    }
    public void	destroy(){

    }
    public String getServletInfo(){
        return "";
    }
    public void	service(ServletRequest req, ServletResponse res)throws ServletException,IOException{
        System.out.println("My First Servlet,Hello Servlet!");
    }
}
