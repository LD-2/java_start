package com.mirror.config;

import com.mirror.servlet.MyServlet;
import jakarta.servlet.ServletRegistration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {


//    注册servlet对象
//public ServletRegistrationBean(T servlet, String... urlMappings)
//有两个参数 一个是servlet对象  一个是url地址
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
//        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(),"/myservlet");
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new MyServlet());
        bean.addUrlMappings("/myservlet");
        return bean;
    }
}
