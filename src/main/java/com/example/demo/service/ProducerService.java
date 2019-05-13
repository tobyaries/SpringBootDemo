package com.example.demo.service;

import javax.jms.Destination;

/**
 * ProducerService
 * 消息生产者
 */
public interface ProducerService {

    /**
     * 功能描述： 指定消息队列，发送消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, final String message);

     /**
     * 功能描述： 使用默认消息队列，发送消息
     * @param destination
     * @param message
     */
    public void sendMessage(final String message);

    public void publish(String msg);
}