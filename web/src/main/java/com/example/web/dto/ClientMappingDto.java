package com.example.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientMappingDto {

    private String id;

    private String client;

    private List<RoleDto> mappings;

}
