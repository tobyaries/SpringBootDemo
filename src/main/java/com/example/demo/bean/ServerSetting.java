package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * ServerSetting
 */
@Component
@PropertySource({"classpath:application.properties"})
@ConfigurationProperties(prefix="test")

public class ServerSetting {
    //名称
    // @Value("${name}")
    private String name;
    //域名
    // @Value("${domain}")
    private String domain;

    public ServerSetting() {
    }
    
    public ServerSetting(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    
}