package com.example.web.controller;


import com.example.web.dto.UserDto;
import com.example.web.dto.UserPasswordDto;
import com.example.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@PreAuthorize("hasRole('hr')")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}/set-password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setPassword(@PathVariable String id, @RequestBody UserPasswordDto userPasswordDto) {
        userService.setPassword(id, userPasswordDto);
    }

}
