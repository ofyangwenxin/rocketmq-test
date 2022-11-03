package com.example.demo.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Slf4j
@Service
public class OrderProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${order.rocketmq.topic}")
    private String orderTopic;

    public void sendMessage(String body) {
        SendResult sendResult = rocketMQTemplate.syncSend(orderTopic, MessageBuilder.withPayload(body).build(), 3000, 2);
        log.info("发送消息:[{}], 发送时间:[{}]", body, LocalDateTime.now());
    }

}
