package com.example.web.feign;

import com.example.web.dto.RoleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "roleMappingFeignClient",
        url = "${keycloak.realm-uri}/users"
)
public interface RoleMappingFeignClient {

    @PostMapping("/{userId}/role-mappings/clients/${keycloak.id-client}")
    void assignClientRoles(@PathVariable String userId, @RequestBody List<RoleDto> roleDtoList);

    @PostMapping("/{userId}/role-mappings/realm")
    void assignRealmRoles(@PathVariable String userId, @RequestBody List<RoleDto> roleDtoList);

    @DeleteMapping("/{userId}/role-mappings/clients/${keycloak.id-client}")
    void unassignClientRoles(@PathVariable String userId, @RequestBody List<RoleDto> roleDtoList);

    @DeleteMapping("/{userId}/role-mappings/realm")
    void unassignRealmRoles(@PathVariable String userId, @RequestBody List<RoleDto> roleDtoList);

}
