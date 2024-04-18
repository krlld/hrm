package com.example.web.controller;

import com.example.commons.service.ServiceInterface;
import com.example.web.dto.NotificationDto;
import com.example.web.producer.Producer;
import com.example.web.service.NotificationService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final Producer producer;

    private final ServiceInterface<NotificationDto, Long> serviceInterface;

    @GetMapping("/unread")
    @ResponseStatus(HttpStatus.OK)
    public Page<NotificationDto> getUnread(Pageable pageable) {
        return ((NotificationService) serviceInterface).getUnread(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@Valid @RequestBody NotificationDto notificationDto) {
        producer.produce(notificationDto);
    }
}
