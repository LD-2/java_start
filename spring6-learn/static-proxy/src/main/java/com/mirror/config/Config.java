package com.mirror.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"com.mirror.impl","com.mirror.proxy"})
public class Config {

}
