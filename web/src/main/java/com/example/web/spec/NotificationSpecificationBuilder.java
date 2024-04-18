package com.example.web.spec;

import com.example.commons.dto.FilterRequest;
import com.example.commons.specification.SpecificationBuilder;
import com.example.web.dto.NotificationFilterDto;
import com.example.web.entity.Notification;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class NotificationSpecificationBuilder implements SpecificationBuilder<Notification> {

    @Override
    public Specification<Notification> build(FilterRequest filterRequest) {
        NotificationFilterDto notificationFilterDto = (NotificationFilterDto) filterRequest;
        return (root, query, builder) -> {
            Predicate predicate = builder.equal(root.get("isRead"), notificationFilterDto.isRead());
            return builder.and(predicate);
        };
    }
}
