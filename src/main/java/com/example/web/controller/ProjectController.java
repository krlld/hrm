package com.example.web.controller;

import com.example.commonlib.service.ServiceInterface;
import com.example.web.dto.ProjectDto;
import com.example.web.dto.ProjectFilterDto;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ServiceInterface<ProjectDto, Long> serviceInterface;

    @PreAuthorize("hasAnyRole('hr')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ProjectDto> findPage(
            @RequestBody(required = false) ProjectFilterDto projectFilterDto,
            Pageable pageable) {
        return serviceInterface.findPage(projectFilterDto, pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDto find(@PathVariable Long id) {
        return serviceInterface.find(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDto create(@Valid @RequestBody ProjectDto projectDto) {
        return serviceInterface.create(projectDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDto update(@Valid @RequestBody ProjectDto projectDto, @PathVariable Long id) {
        projectDto.setId(id);
        return serviceInterface.update(projectDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        serviceInterface.delete(id);
    }
}
