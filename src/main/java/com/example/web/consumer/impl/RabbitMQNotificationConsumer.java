package com.example.web.consumer.impl;

import com.example.commonlib.service.ServiceInterface;
import com.example.web.consumer.Consumer;
import com.example.web.dto.NotificationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQNotificationConsumer implements Consumer {

    private final ServiceInterface<NotificationDto, Long> serviceInterface;

    @Override
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(NotificationDto notificationDto) {
        log.info(String.format("Message consume %s", notificationDto));
        serviceInterface.create(notificationDto);
    }
}
