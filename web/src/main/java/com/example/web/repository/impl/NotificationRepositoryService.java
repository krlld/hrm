package com.example.web.repository.impl;

import com.example.commonlib.repository.AbstractRepositoryService;
import com.example.commonlib.repository.BaseRepository;
import com.example.commonlib.specification.SpecificationBuilder;
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
