package com.example.demo_spring_security.dto.security;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
