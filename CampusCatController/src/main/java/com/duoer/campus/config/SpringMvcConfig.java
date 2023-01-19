package com.duoer.campus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.duoer.campus.web", "com.duoer.campus.config"})
@EnableWebMvc
@EnableAspectJAutoProxy
public class SpringMvcConfig {
}
