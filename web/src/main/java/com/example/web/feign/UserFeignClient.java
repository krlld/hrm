package com.example.web.feign;

import com.example.web.dto.UserDto;
import com.example.web.dto.UserPasswordDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "userFeignClient",
        url = "${keycloak.realm-uri}/users"
)
public interface UserFeignClient {

    @GetMapping
    List<UserDto> getUsers();

    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable String id);

    @PostMapping
    UserDto createUser(@RequestBody UserDto userDto);

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable String id);

    @PutMapping("/{id}/reset-password")
    void setPassword(@PathVariable String id, UserPasswordDto userPasswordDto);

}
