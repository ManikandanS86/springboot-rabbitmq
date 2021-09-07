package com.example.springbootrabbitmq.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rabbitmq")
public class RabbitMqWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "produce")
    public String producer(@RequestParam("data") String data) {
        rabbitMQSender.send(data);
        return "Message sent successfully";
    }

}
