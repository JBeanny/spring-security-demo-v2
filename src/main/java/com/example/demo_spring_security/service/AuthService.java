package com.example.demo_spring_security.service;

import com.example.demo_spring_security.common.exception.DuplicateResourceException;
import com.example.demo_spring_security.dto.security.AuthRequest;
import com.example.demo_spring_security.dto.security.AuthResponse;
import com.example.demo_spring_security.dto.security.RegisterRequest;
import com.example.demo_spring_security.entity.User;
import com.example.demo_spring_security.enums.Role;
import com.example.demo_spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateResourceException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole() != null ? Role.valueOf(request.getRole()).name() : Role.USER.name());

        userRepository.save(user);

        return new AuthResponse("", "User registered successfully");
    }

    public AuthResponse login(AuthRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
//        );

        return new AuthResponse("", "Login successful");
    }
}
