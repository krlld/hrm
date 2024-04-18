package com.example.web.consumer;

import com.example.web.dto.NotificationDto;

public interface Consumer {

    void consume(NotificationDto notificationDto);
}
