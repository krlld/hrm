package com.example.web.spec;

import com.example.commonlib.dto.FilterRequest;
import com.example.commonlib.specification.SpecificationBuilder;
import com.example.web.dto.ProjectFilterDto;
import com.example.web.entity.Project;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectSpecificationBuilder implements SpecificationBuilder<Project> {

    @Override
    public Specification<Project> build(@Nullable FilterRequest filterRequest) {
        if (filterRequest == null) {
            return (root, query, builder) -> builder.and();
        }
        ProjectFilterDto projectFilterDto = (ProjectFilterDto) filterRequest;
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (projectFilterDto.getTitle() != null) {
                predicates.add(builder.like(root.get("title"), "%" + projectFilterDto.getTitle() + "%"));
            }
            if (projectFilterDto.getDescription() != null) {
                predicates.add(builder.like(root.get("description"), "%" + projectFilterDto.getDescription() + "%"));
            }
            if (projectFilterDto.getBudget() != null) {
                predicates.add(builder.lessThan(root.get("budget"), projectFilterDto.getBudget()));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
