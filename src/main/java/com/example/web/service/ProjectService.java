package com.example.web.service;

import com.example.commonlib.mapper.MapperService;
import com.example.commonlib.repository.RepositoryService;
import com.example.commonlib.service.AbstractService;
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
