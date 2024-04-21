package com.example.web.service.impl;

import com.example.web.dto.RoleDto;
import com.example.web.feign.RoleMappingFeignClient;
import com.example.web.service.RoleMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleMappingServiceImpl implements RoleMappingService {

    private final RoleMappingFeignClient roleMappingFeignClient;

    @Override
    public void assignRoles(String userId, List<RoleDto> roleDtoList) {
        roleMappingFeignClient.assignClientRoles(userId, isClientRoles(roleDtoList, Boolean.TRUE));
        roleMappingFeignClient.assignRealmRoles(userId, isClientRoles(roleDtoList, Boolean.FALSE));
    }

    @Override
    public void unassignRoles(String userId, List<RoleDto> roleDtoList) {
        roleMappingFeignClient.unassignClientRoles(userId, isClientRoles(roleDtoList, Boolean.TRUE));
        roleMappingFeignClient.unassignRealmRoles(userId, isClientRoles(roleDtoList, Boolean.FALSE));
    }

    private List<RoleDto> isClientRoles(List<RoleDto> roleDtoList, Boolean isClientRole) {
        return roleDtoList.stream()
                .collect(Collectors.partitioningBy(RoleDto::isClientRole))
                .get(isClientRole);
    }

}
