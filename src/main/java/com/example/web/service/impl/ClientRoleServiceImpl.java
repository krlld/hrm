package com.example.web.service.impl;

import com.example.web.dto.RoleDto;
import com.example.web.feign.ClientRoleFeignClient;
import com.example.web.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("clientRoleService")
public class ClientRoleServiceImpl implements RoleService {

    private final ClientRoleFeignClient clientRoleFeignClient;

    @Override
    public List<RoleDto> getRoles() {
        return clientRoleFeignClient.getClientRoles();
    }

    @Override
    public RoleDto getRoleById(String id) {
        return clientRoleFeignClient.getClientRoleById(id);
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        return clientRoleFeignClient.createClientRole(roleDto);
    }

    @Override
    public RoleDto updateRole(String id, RoleDto roleDto) {
        return clientRoleFeignClient.updateClientRole(id, roleDto);
    }

    @Override
    public void deleteRole(String id) {
        clientRoleFeignClient.deleteClientRole(id);
    }
}
