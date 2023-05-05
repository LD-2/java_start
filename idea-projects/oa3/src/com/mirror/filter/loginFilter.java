package com.mirror.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class loginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//      首页放行不然会进入循环
//      登入界面放行执行servlet 需要注册session
//      登入错误界面放行  不然不会提示登入错误 直接返回index.jsp
//      退出界面放行  不然无法销毁session 或 cookie
//      已登入后的情况放行
//      已登入后 但是直接访问某些jsp 拦截  这个没有实现
//      欢迎界面也要放行 十天免登录


        String servletPath = request.getServletPath();
        HttpSession session = request.getSession(false);
        if("/index.jsp".equals(servletPath)
                ||"/user/login".equals(servletPath)
                ||"/user/exit".equals(servletPath)
                ||"/error.jsp".equals(servletPath)
                ||"/welcome".equals(servletPath)
                ||session!=null&&session.getAttribute("user")!=null
                ) {
            filterChain.doFilter(request,response);
        }else{
            response.sendRedirect(request.getContextPath());
        }
    }
}
