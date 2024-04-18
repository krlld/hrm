package com.example.web.service;

import com.example.commons.mapper.MapperService;
import com.example.commons.repository.RepositoryService;
import com.example.commons.service.AbstractService;
import com.example.web.dto.NotificationDto;
import com.example.web.entity.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService extends AbstractService<Notification, NotificationDto, Long> {

    public NotificationService(
            RepositoryService<Notification, Long> repositoryService,
            MapperService<Notification, NotificationDto> mapperService) {
        super(repositoryService, mapperService);
    }
}
