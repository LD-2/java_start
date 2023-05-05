package com.mirror.config;

import com.mirror.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {


    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean reg = new FilterRegistrationBean();
        //使用哪个过滤器
        reg.setFilter(new MyFilter());
        //过滤器地址
        reg.addUrlPatterns("/user/*");
        return reg;
    }

}
