package com.example.web.dto;

import lombok.Data;

@Data
public class UserPasswordDto {

    private boolean temporary;

    private String type;

    private String value;

}
