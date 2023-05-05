package com.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class TestServlet2 extends GenericServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("TestServlet2's init()");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("TestServlet's service()");
    }
}
