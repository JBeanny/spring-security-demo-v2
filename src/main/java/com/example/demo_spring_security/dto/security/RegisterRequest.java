package com.example.demo_spring_security.dto.security;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String role;
}
