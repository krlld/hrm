package com.example.web.service;

import com.example.web.dto.RoleDto;

import java.util.List;

public interface RoleMappingService {

    void assignRoles(String userId, List<RoleDto> roleDtoList);

    void unassignRoles(String userId, List<RoleDto> roleDtoList);

}
