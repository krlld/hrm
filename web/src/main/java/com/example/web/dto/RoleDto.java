package com.example.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto {

    private String id;

    private String name;

    private String description;

    private Map<String, Object> attributes;

    private boolean clientRole;

    private boolean composite;

    private String containerId;

}
