package com.jin.issuesticker.user.dto;

import lombok.Data;


@Data
public class JoinUserDto {
    private String id;
    private String name;
    private String password;
    private String email;

    private boolean result;
}
