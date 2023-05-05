package com.mirror.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mirror.annotation.bean","com.mirror.annotation.dao2"})
public class Spring6Config {

}
