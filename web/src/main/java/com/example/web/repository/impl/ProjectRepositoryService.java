package com.example.web.repository.impl;

import com.example.commons.repository.AbstractRepositoryService;
import com.example.commons.repository.BaseRepository;
import com.example.commons.specification.SpecificationBuilder;
import com.example.web.entity.Project;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepositoryService extends AbstractRepositoryService<Project, Long> {

    public ProjectRepositoryService(
            BaseRepository<Project, Long> repository,
            SpecificationBuilder<Project> specificationBuilder) {
        super(repository, specificationBuilder);
    }
}
