package com.example.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolesDto {

    private List<RoleDto> realmMappings;

    private Map<String, ClientMappingDto> clientMappings;

}
