package com.example.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * CustomContextListener
 */
@WebListener
public class CustomContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // ServletContextListener.super.contextDestroyed(sce);
        System.out.println("====contextDestroyed====");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // ServletContextListener.super.contextInitialized(sce);
        System.out.println("====contextInitialized====");
    }

    
}