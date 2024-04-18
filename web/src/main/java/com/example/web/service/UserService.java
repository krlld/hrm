package com.example.web.service;

import com.example.web.dto.UserDto;
import com.example.web.dto.UserPasswordDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();

    UserDto createUser(UserDto userDto);

    void deleteUser(String id);

    void setPassword(String id, UserPasswordDto userPasswordDto);

    UserDto getUserById(String id);

}
