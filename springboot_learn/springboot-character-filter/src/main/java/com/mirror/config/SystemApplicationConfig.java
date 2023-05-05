package com.mirror.config;

import com.mirror.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class SystemApplicationConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean reg = new ServletRegistrationBean<>(new MyServlet(),"/myserlet");
        return reg;
    }

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean reg = new FilterRegistrationBean();
//        //创建 CharacterEncodingFilter  这里不用再实现Filter接口 实现了 这个 包中已经实现了
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("utf-8");
//        characterEncodingFilter.setForceEncoding(true);
//        reg.setFilter(characterEncodingFilter);
//        reg.addUrlPatterns("/*");
//        return reg;
//    }
}
