package com.example.web.producer;

import com.example.web.dto.NotificationDto;

public interface Producer {

    void produce(NotificationDto notificationDto);
}
