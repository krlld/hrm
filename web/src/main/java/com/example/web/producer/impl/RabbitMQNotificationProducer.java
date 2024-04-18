package com.example.web.producer.impl;

import com.example.web.dto.NotificationDto;
import com.example.web.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class RabbitMQNotificationProducer implements Producer {

    private final String exchange;

    private final String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQNotificationProducer(
            @Value("${rabbitmq.exchange}") String exchange,
            @Value("${rabbitmq.routingKey}") String routingKey,
            RabbitTemplate rabbitTemplate) {
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void produce(NotificationDto notificationDto) {
        notificationDto.setExchange(exchange);
        notificationDto.setRoutingKey(routingKey);
        notificationDto.setCreatedAt(LocalDateTime.now());
        log.info(String.format("Message produce %s", notificationDto));
        rabbitTemplate.convertAndSend(exchange, routingKey, notificationDto);
    }
}
