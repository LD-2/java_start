package com.mirror.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//全注解式开发AOP
@Configuration
@ComponentScan("com.mirror")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config6 {

}
