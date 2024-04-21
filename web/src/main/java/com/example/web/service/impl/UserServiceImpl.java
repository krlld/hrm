package com.example.web.service.impl;

import com.example.web.dto.GroupDto;
import com.example.web.dto.RoleDto;
import com.example.web.dto.RolesDto;
import com.example.web.dto.UserDto;
import com.example.web.dto.UserPasswordDto;
import com.example.web.feign.UserFeignClient;
import com.example.web.service.RoleMappingService;
import com.example.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserFeignClient userFeignClient;

    private final RoleMappingService roleMappingService;

    @Override
    public List<UserDto> getUsers() {
        return userFeignClient.getUsers();
    }

    @Override
    public UserDto getUserById(String id) {
        return userFeignClient.getUserById(id);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userFeignClient.createUser(userDto);
    }

    @Override
    public void deleteUser(String id) {
        userFeignClient.deleteUser(id);
    }

    @Override
    public void setPassword(String id, UserPasswordDto userPasswordDto) {
        userFeignClient.setPassword(id, userPasswordDto);
    }

    @Override
    public RolesDto getRoles(String id) {
        return userFeignClient.getRoles(id);
    }

    @Override
    public void assignRoles(String id, List<RoleDto> roleDtoList) {
        roleMappingService.assignRoles(id, roleDtoList);
    }

    @Override
    public void unassignRoles(String id, List<RoleDto> roleDtoList) {
        roleMappingService.unassignRoles(id, roleDtoList);
    }

    @Override
    public List<GroupDto> getAvailableRealmRoles(String userId) {
        return userFeignClient.getAvailableRealmRoles(userId);
    }

    @Override
    public List<GroupDto> getAvailableClientRoles(String userId, String clientId) {
        return userFeignClient.getAvailableClientRoles(userId, clientId);
    }
}
