package com.example.web.feign;

import com.example.web.dto.GroupCountDto;
import com.example.web.dto.GroupDto;
import com.example.web.dto.RolesDto;
import com.example.web.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "groupFeignClient",
        url = "${keycloak.realm-uri}/groups"
)
public interface GroupFeignClient {

    @GetMapping
    List<GroupDto> getGroups();

    @GetMapping("/{id}")
    GroupDto getGroupById(@PathVariable String id);

    @PostMapping
    GroupDto createGroup(GroupDto groupDto);

    @PutMapping("/{id}")
    GroupDto updateGroup(
            @PathVariable String id,
            @RequestBody GroupDto groupDto);

    @DeleteMapping("/{id}")
    GroupDto deleteGroup(@PathVariable String id);

    @GetMapping("/{id}/children")
    List<GroupDto> getSubgroups(@PathVariable String id);

    @PostMapping("/{id}/children")
    GroupDto createSubgroup(
            @PathVariable String id,
            @RequestBody GroupDto groupDto);

    @GetMapping("/{id}/members")
    List<UserDto> getMembers(@PathVariable String id);

    @GetMapping
    GroupCountDto getGroupCount();

    @GetMapping("/{groupId}/role-mappings")
    RolesDto getRoles(@PathVariable String groupId);

    @GetMapping("/{groupId}/role-mappings/clients/{clientId}")
    List<GroupDto> getClientRoles(
            @PathVariable String groupId,
            @PathVariable String clientId);

    @GetMapping("/{groupId}/role-mappings/clients/{clientId}/available")
    List<GroupDto> getAvailableClientRoles(
            @PathVariable String groupId,
            @PathVariable String clientId);

    @DeleteMapping("/{groupId}/role-mappings/clients/{clientId}")
    void deleteClientRolesByClientId(
            @PathVariable String groupId,
            @PathVariable String clientId);

    @PostMapping("/{groupId}/role-mappings/clients/{clientId}")
    List<GroupDto> addClientRoles(
            @PathVariable String groupId,
            @PathVariable String clientId,
            @RequestBody List<GroupDto> groupDtoList);

    @GetMapping("/{groupId}/role-mappings/realm/available")
    List<GroupDto> getAvailableRealmRoles(@PathVariable String groupId);

    @GetMapping("/{groupId}/role-mappings/realm")
    List<GroupDto> getRealmRoles(@PathVariable String groupId);

    @DeleteMapping("/{groupId}/role-mappings/realm")
    void deleteRealmRoles(@PathVariable String groupId);

    @PostMapping("/{groupId}/role-mappings/realm")
    List<GroupDto> addRealmRoles(
            @PathVariable String groupId,
            @RequestBody List<GroupDto> groupDtoList);

}
