package com.example.web.service.impl;

import com.example.web.dto.RoleDto;
import com.example.web.feign.RoleMappingFeignClient;
import com.example.web.service.RoleMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleMappingServiceImpl implements RoleMappingService {

    private final RoleMappingFeignClient roleMappingFeignClient;

    @Override
    public void assignRoles(String userId, List<RoleDto> roleDtoList) {
        roleDtoList.forEach(roleDto -> {
            if (roleDto.isClientRole()) {
                roleMappingFeignClient.assignClientRoles(userId, List.of(roleDto));
            } else {
                roleMappingFeignClient.assignRealmRoles(userId, List.of(roleDto));
            }
        });
    }

    @Override
    public void unassignRoles(String userId, List<RoleDto> roleDtoList) {
        roleDtoList.forEach(roleDto -> {
            if (roleDto.isClientRole()) {
                roleMappingFeignClient.unassignClientRoles(userId, List.of(roleDto));
            } else {
                roleMappingFeignClient.unassignRealmRoles(userId, List.of(roleDto));
            }
        });

    }
}
