package com.example.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * OrderConsumer
 */
@Component
public class TopicConsumer {
    @JmsListener(destination = "vedio.queue", containerFactory = "jmsListenerContainerTopic")
    public void receive1(String text) {
        System.out.println("TopicConsumer1 收到的报文为: " + text);
    }
    @JmsListener(destination = "vedio.queue", containerFactory = "jmsListenerContainerTopic")
    public void receive2(String text) {
        System.out.println("TopicConsumer2 收到的报文为: " + text);
    }
    @JmsListener(destination = "vedio.queue", containerFactory = "jmsListenerContainerTopic")
    public void receive3(String text) {
        System.out.println("TopicConsumer3 收到的报文为: " + text);
    }
}
