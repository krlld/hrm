package com.example.web.controller;


import com.example.web.dto.RoleDto;
import com.example.web.service.RoleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client-roles")
public class ClientRoleController {

    private final RoleService roleService;

    public ClientRoleController(@Qualifier("clientRoleService") RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RoleDto> getClientRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDto getClientRoleById(@PathVariable String id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDto createClientRole(@RequestBody RoleDto roleDto) {
        return roleService.createRole(roleDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDto updateClientRole(
            @PathVariable String id,
            @RequestBody RoleDto roleDto) {
        return roleService.updateRole(id, roleDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientRole(@PathVariable String id) {
        roleService.deleteRole(id);
    }

}
