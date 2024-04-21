package com.example.web.service;

import com.example.web.dto.GroupCountDto;
import com.example.web.dto.GroupDto;
import com.example.web.dto.RolesDto;
import com.example.web.dto.UserDto;

import java.util.List;

public interface GroupService {

    List<GroupDto> getGroups();

    GroupDto getGroupById(String id);

    GroupDto createGroup(GroupDto groupDto);

    GroupDto updateGroup(String id, GroupDto groupDto);

    GroupDto deleteGroup(String id);

    List<GroupDto> getSubgroups(String id);

    GroupDto createSubgroup(String id, GroupDto groupDto);

    List<UserDto> getMembers(String id);

    GroupCountDto getGroupCount();

    RolesDto getRoles(String groupId);

    List<GroupDto> getClientRoles(String groupId, String clientId);

    List<GroupDto> getAvailableClientRoles(String groupId, String clientId);

    void deleteClientRolesByClientId(String groupId, String clientId);

    List<GroupDto> addClientRoles(String groupId, String clientId, List<GroupDto> groupDtoList);

    List<GroupDto> getAvailableRealmRoles(String groupId);

    List<GroupDto> getRealmRoles(String groupId);

    void deleteRealmRoles(String groupId);

    List<GroupDto> addRealmRoles(String groupId, List<GroupDto> groupDtoList);
}
