package com.example.demo;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
// import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * runApplication
 */
@SpringBootApplication
@ServletComponentScan
public class RunApplication {
// public class RunApplication extends SpringBootServletInitializer {
    // 打成war包需要进行继承和重写
    // @Override
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    //     return builder.sources(RunApplication.class);
    // }

    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大
        factory.setMaxFileSize("100KB");
        // 设置上传数据总大小
        factory.setMaxRequestSize("1024000KB");
        return factory.createMultipartConfig();
    }
}
