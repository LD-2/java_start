package com.mirror.config;

import com.mirror.web.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        通过重写 添加拦截器 指定要添加的拦截器 和 要拦截的路径 以及放行的路径
        String path [] = {"/user/**"};
        String excludePath [] = {"/user/login"};
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(path).excludePathPatterns(excludePath);
    }
}
