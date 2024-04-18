package com.example.web.repository.impl;

import com.example.commons.repository.AbstractRepositoryService;
import com.example.commons.repository.BaseRepository;
import com.example.commons.specification.SpecificationBuilder;
import com.example.web.entity.Notification;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepositoryService extends AbstractRepositoryService<Notification, Long> {

    public NotificationRepositoryService(
            BaseRepository<Notification, Long> repository,
            SpecificationBuilder<Notification> specificationBuilder) {
        super(repository, specificationBuilder);
    }
}
