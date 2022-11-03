package com.example.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RocketMQMessageListener(topic = "${order.rocketmq.topic}", consumerGroup = "order_consumer_group")
public class OrderConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("接收消息:[{}], 接收时间:[{}]", message, LocalDateTime.now());
    }
}
