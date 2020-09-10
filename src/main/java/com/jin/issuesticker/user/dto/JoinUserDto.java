package com.jin.issuesticker.user.dto;

import lombok.Data;

import java.util.List;


@Data
public class JoinUserDto {
    private String id;
    private String name;
    private String password;
    private String email;
    private List<String> roles;

    private boolean result;
}
