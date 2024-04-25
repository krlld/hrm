package com.example.web.feign;


import com.example.web.dto.RoleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "realmRoleFeignClient",
        url = "${keycloak.realm-uri}"
)
public interface RealmRoleFeignClient {

    @GetMapping("/roles")
    List<RoleDto> getRealmRoles();

    @GetMapping("/roles-by-id/{id}")
    RoleDto getRealmRoleById(@PathVariable String id);

    @PostMapping("/roles")
    RoleDto createRealmRole(@RequestBody RoleDto roleDto);

    @PutMapping("/roles-by-id/{id}")
    RoleDto updateRealmRole(@PathVariable String id, @RequestBody RoleDto roleDto);

    @DeleteMapping("/roles-by-id/{id}")
    void deleteRealmRole(@PathVariable String id);

}
