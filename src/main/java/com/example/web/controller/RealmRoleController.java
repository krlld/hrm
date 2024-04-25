package com.example.web.controller;

import com.example.web.dto.RoleDto;
import com.example.web.service.RoleService;
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
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@RestController
//@PreAuthorize("hasRole('admin')")
@RequestMapping("/realm-roles")
public class RealmRoleController {

    private final RoleService roleService;

    public RealmRoleController(@Qualifier("realmRoleService") RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RoleDto> getRealmRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDto getRealmRoleById(@PathVariable String id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    RoleDto createRealmRole(@RequestBody RoleDto roleDto) {
        return roleService.createRole(roleDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    RoleDto updateRealmRole(@PathVariable String id, @RequestBody RoleDto roleDto) {
        return roleService.updateRole(id, roleDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRealmRole(@PathVariable String id) {
        roleService.deleteRole(id);
    }

    // TODO: /realm/available

    // GET /admin/realms/{realm}/roles/{role-name}/groups

    // GET /admin/realms/{realm}/roles/{role-name}/users

}
