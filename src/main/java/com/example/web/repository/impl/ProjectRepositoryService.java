package com.example.web.repository.impl;

import com.example.commonlib.repository.AbstractRepositoryService;
import com.example.commonlib.repository.BaseRepository;
import com.example.commonlib.specification.SpecificationBuilder;
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
