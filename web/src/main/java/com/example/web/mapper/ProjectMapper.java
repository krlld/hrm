package com.example.web.mapper;

import com.example.commons.mapper.MapperService;
import com.example.web.dto.ProjectDto;
import com.example.web.entity.Project;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper extends MapperService<Project, ProjectDto> {

    ProjectDto toDto(Project project);

    Project toEntity(ProjectDto projectDto);
}
