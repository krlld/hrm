package com.example.web.service;

import com.example.commons.mapper.MapperService;
import com.example.commons.repository.RepositoryService;
import com.example.commons.service.AbstractService;
import com.example.web.dto.ProjectDto;
import com.example.web.entity.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends AbstractService<Project, ProjectDto, Long> {

    public ProjectService(
            RepositoryService<Project, Long> repositoryService,
            MapperService<Project, ProjectDto> mapperService) {
        super(repositoryService, mapperService);
    }
}
