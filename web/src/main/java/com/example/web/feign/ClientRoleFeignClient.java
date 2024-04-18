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
        name = "clientRoleFeignClient",
        url = "${keycloak.realm-uri}"
)
public interface ClientRoleFeignClient {

    @GetMapping("/clients/${keycloak.id-client}/roles")
    List<RoleDto> getClientRoles();

    @GetMapping("/roles-by-id/{id}")
    RoleDto getClientRoleById(@PathVariable String id);

    @PostMapping("/clients/${keycloak.id-client}/roles")
    RoleDto createClientRole(@RequestBody RoleDto roleDto);

    @PutMapping("/roles-by-id/{id}")
    RoleDto updateClientRole(@PathVariable String id, @RequestBody RoleDto roleDto);

    @DeleteMapping("/roles-by-id/{id}")
    void deleteClientRole(@PathVariable String id);

}
