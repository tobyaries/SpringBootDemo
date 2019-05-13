package com.example.demo.controller.order;

import javax.jms.Destination;

import com.example.demo.bean.JsonData;
import com.example.demo.service.ProducerService;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("order")
    public Object order(String msg) {
        Destination destination = new ActiveMQQueue("order.queue");
        producerService.sendMessage(destination, msg);
        return JsonData.buildSuccess();
    }

    @GetMapping("comment")
    public Object comment(String msg) {
        producerService.sendMessage(msg);
        return JsonData.buildSuccess();
    }

    @GetMapping("topic")
    public Object topic(String msg) {
        producerService.publish(msg);
        return JsonData.buildSuccess();
    }
}