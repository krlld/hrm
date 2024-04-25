package com.example.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private String id;

    private String username;

    private boolean emailVerified;

    private boolean enabled;

    private String email;

    private String firstName;

    private List<String> groups;

    private String lastName;

    private List<String> requiredActions;

    private Map<String, List<String>> attributes;

    private List<UserPasswordDto> credentials;

    private List<String> realmRoles;

}
