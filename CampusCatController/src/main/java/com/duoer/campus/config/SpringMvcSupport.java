package com.duoer.campus.config;

import com.duoer.campus.web.interceptor.AdminInterceptor;
import com.duoer.campus.web.interceptor.LogInInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private LogInInterceptor logInInterceptor;
    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInInterceptor).addPathPatterns("/feedings/**", "/appearances/**", "/cats/**");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**");
    }
}
