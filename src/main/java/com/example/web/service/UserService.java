package com.example.web.service;

import com.example.web.dto.GroupDto;
import com.example.web.dto.RoleDto;
import com.example.web.dto.RolesDto;
import com.example.web.dto.UserDto;
import com.example.web.dto.UserPasswordDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();

    UserDto createUser(UserDto userDto);

    void deleteUser(String id);

    void setPassword(String id, UserPasswordDto userPasswordDto);

    UserDto getUserById(String id);

    RolesDto getRoles(String id);

    void assignRoles(String id, List<RoleDto> roleDtoList);

    void unassignRoles(String id, List<RoleDto> roleDto);

    List<GroupDto> getAvailableClientRoles(String userId, String clientId);
}
