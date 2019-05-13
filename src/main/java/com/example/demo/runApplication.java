package com.example.demo;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.MultipartConfigElement;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
// import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

/**
 * runApplication
 */
@SpringBootApplication
@EnableJms
// @ComponentScan({"com.example.demo", "com.example.demo.controller.users"})
@ServletComponentScan
@MapperScan("com.example.demo.dao")
public class RunApplication {
// public class RunApplication extends SpringBootServletInitializer {
    // 打成war包需要进行继承和重写
    // @Override
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    //     return builder.sources(RunApplication.class);
    // }

    /**
     * 交给Spring进行管理，方便后续进行注入
     */
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("comment.queue");
    }
    /**
     * 主题对象交给spring管理
     * @return
     */
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("vedio.queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
        // ApplicationContext  applicationContext = SpringApplication.run(RunApplication.class, args);
        // for(String name: applicationContext.getBeanDefinitionNames()) {
        //     System.out.println(name);
        // }
    }

    /**
     * 需要给topic定义独立的jmsListenerContainer
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
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
