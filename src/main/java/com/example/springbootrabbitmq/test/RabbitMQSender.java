package com.example.springbootrabbitmq.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.test.exchange}")
    private String exchange;

    @Value("${rabbitmq.test.routingkey}")
    private String routingkey;

    public void send(String data) {
        rabbitTemplate.convertAndSend(exchange, routingkey, data);
        System.out.println("Sent msg = " + data);
    }
}
