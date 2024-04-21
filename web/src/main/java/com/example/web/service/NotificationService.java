package com.example.web.service;

import com.example.commons.dto.FilterRequest;
import com.example.commons.mapper.MapperService;
import com.example.commons.repository.RepositoryService;
import com.example.commons.service.AbstractService;
import com.example.web.dto.NotificationDto;
import com.example.web.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService extends AbstractService<Notification, NotificationDto, Long> {

    public NotificationService(
            RepositoryService<Notification, Long> repositoryService,
            MapperService<Notification, NotificationDto> mapperService) {
        super(repositoryService, mapperService);
    }

    @Override
    @Transactional
    public Page<NotificationDto> findPage(FilterRequest filter, Pageable pageable) {
        Page<NotificationDto> notificationDtos = super.findPage(filter, pageable);
        notificationDtos.forEach(notificationDto -> notificationDto.setIsRead(Boolean.TRUE));
        createAll(notificationDtos);
        return notificationDtos;
    }
}
