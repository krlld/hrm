package com.example.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDto {

    private String id;

    private String name;

    private String path;

    private String parentId;

    private String description;

    private boolean composite;

    private boolean clientRole;

    private String containerId;

    private Long subGroupCount;

    private List<GroupDto> subGroups;

    private Map<String, List<String>> attributes;

    private List<String> realmRoles;

    private Map<String, List<String>> clientRoles;

    private Map<String, Boolean> access;

}
