package com.mirror;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter({"*.do"})
public class FilterA implements Filter {

    public FilterA(){
        System.out.println("FilterA无参构造方法执行");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterA init()方法执行");
    }

    @Override
    public void destroy() {
        System.out.println("FilterA destory()方法执行");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        强制类型转换 请求 响应对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        System.out.println("FilterA逻辑前");
        //想要执行目标servlet就一定要执行filterChain 这也是后来代码中放行拦截servlet的核心方法
        //执行下一个 Filter 如果没有下一个Filter就直接执行 请求路径对应的Servlet方法
        filterChain.doFilter(request,response);
        System.out.println("FilterA逻辑后");
    }
}
