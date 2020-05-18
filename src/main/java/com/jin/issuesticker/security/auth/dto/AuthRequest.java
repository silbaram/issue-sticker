package com.jin.issuesticker.security.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class AuthRequest {
    private String id;
    private String password;
}
