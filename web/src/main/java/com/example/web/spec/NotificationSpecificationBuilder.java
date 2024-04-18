package com.example.web.spec;

import com.example.commons.dto.FilterRequest;
import com.example.commons.specification.SpecificationBuilder;
import com.example.web.entity.Notification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class NotificationSpecificationBuilder implements SpecificationBuilder<Notification> {

    @Override
    public Specification<Notification> build(FilterRequest filterRequest) {
        // TODO: Implement if needed
        return null;
    }
}
