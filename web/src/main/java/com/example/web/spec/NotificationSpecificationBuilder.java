package com.example.web.spec;

import com.example.commons.dto.FilterRequest;
import com.example.commons.specification.SpecificationBuilder;
import com.example.web.dto.NotificationFilterDto;
import com.example.web.entity.Notification;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationSpecificationBuilder implements SpecificationBuilder<Notification> {

    @Override
    public Specification<Notification> build(@Nullable FilterRequest filterRequest) {
        if (filterRequest == null) {
            return (root, query, builder) -> builder.and();
        }
        NotificationFilterDto notificationFilterDto = (NotificationFilterDto) filterRequest;
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (notificationFilterDto.getIsRead() != null) {
                predicates.add(builder.equal(root.get("isRead"), notificationFilterDto.getIsRead()));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
