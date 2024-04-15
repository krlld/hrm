package com.example.web.spec;

import com.example.commons.dto.FilterRequest;
import com.example.commons.specification.SpecificationBuilder;
import com.example.web.dto.ProjectFilterDto;
import com.example.web.entity.Project;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectSpecificationBuilder implements SpecificationBuilder<Project> {

    @Override
    public Specification<Project> build(FilterRequest filterRequest) {
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
