package com.example.demo.service.impl;

import javax.jms.Destination;
import javax.jms.Queue;
import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * ProducerServiceImpl
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void sendMessage(Destination destination, String message) {
        jmsTemplate.convertAndSend(destination, message);

    }

    @Override
    public void sendMessage(final String message) {
        jmsTemplate.convertAndSend(this.queue, message);
    }
}