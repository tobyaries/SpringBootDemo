package com.example.demo.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CustomIntercepter
 */
@Configuration
public class CustomIntercepterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**").excludePathPatterns("/api2/xxx/**");
        registry.addInterceptor(new LoginIntercepter2()).addPathPatterns("/api2/*/**").excludePathPatterns("/api2/xxx/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}