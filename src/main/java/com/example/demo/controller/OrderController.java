package com.example.demo.controller;

import com.example.demo.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @GetMapping("/createOrder")
    public String createOrder(String param) {
        orderProducer.sendMessage(param);
        return "success";
    }

}
