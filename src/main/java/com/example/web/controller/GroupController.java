package com.example.web.controller;

import com.example.web.dto.GroupCountDto;
import com.example.web.dto.GroupDto;
import com.example.web.dto.RolesDto;
import com.example.web.dto.UserDto;
import com.example.web.service.GroupService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GroupDto getGroupById(@PathVariable String id) {
        return groupService.getGroupById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public GroupDto createGroup(@RequestBody GroupDto groupDto) {
        return groupService.createGroup(groupDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GroupDto updateGroup(@PathVariable String id, @RequestBody GroupDto groupDto) {
        return groupService.updateGroup(id, groupDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public GroupDto deleteGroup(@PathVariable String id) {
        return groupService.deleteGroup(id);
    }

    @GetMapping("/{id}/subgroups")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> getSubgroups(@PathVariable String id) {
        return groupService.getSubgroups(id);
    }

    @PostMapping("/{id}/subgroups")
    @ResponseStatus(HttpStatus.OK)
    public GroupDto createSubgroup(@PathVariable String id, @RequestBody GroupDto groupDto) {
        return groupService.createSubgroup(id, groupDto);
    }

    @GetMapping("/{id}/members")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getMembers(@PathVariable String id) {
        return groupService.getMembers(id);
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public GroupCountDto getGroupCount() {
        return groupService.getGroupCount();
    }

    @GetMapping("/{groupId}/roles")
    @ResponseStatus(HttpStatus.OK)
    public RolesDto getRoles(@PathVariable String groupId) {
        return groupService.getRoles(groupId);
    }

    @GetMapping("/{groupId}/roles/clients/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> getClientRoles(@PathVariable String groupId, @PathVariable String clientId) {
        return groupService.getClientRoles(groupId, clientId);
    }

    @GetMapping("/{groupId}/roles/clients/{clientId}/available")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> getAvailableClientRoles(@PathVariable String groupId, @PathVariable String clientId) {
        return groupService.getAvailableClientRoles(groupId, clientId);
    }

    @DeleteMapping("/{groupId}/roles/clients/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientRolesByClientId(@PathVariable String groupId, @PathVariable String clientId) {
        groupService.deleteClientRolesByClientId(groupId, clientId);
    }

    @PostMapping("/{groupId}/roles/clients/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> addClientRoles(
            @PathVariable String groupId,
            @PathVariable String clientId,
            @RequestBody List<GroupDto> groupDtoList) {
        return groupService.addClientRoles(groupId, clientId, groupDtoList);
    }

    @GetMapping("/{groupId}/roles/realm/available")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> getAvailableRealmRoles(@PathVariable String groupId) {
        return groupService.getAvailableRealmRoles(groupId);
    }

    @GetMapping("/{groupId}/roles/realm")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> getRealmRoles(@PathVariable String groupId) {
        return groupService.getRealmRoles(groupId);
    }

    @DeleteMapping("/{groupId}/roles/realm")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRealmRoles(@PathVariable String groupId) {
        groupService.deleteRealmRoles(groupId);
    }

    @PostMapping("/{groupId}/roles/realm")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> addRealmRoles(
            @PathVariable String groupId,
            @RequestBody List<GroupDto> groupDtoList) {
        return groupService.addRealmRoles(groupId, groupDtoList);
    }

    // GET /admin/realms/{realm}/clients/{client-uuid}/roles/{role-name}/groups
    // GET /admin/realms/{realm}/roles/{role-name}/groups

}
