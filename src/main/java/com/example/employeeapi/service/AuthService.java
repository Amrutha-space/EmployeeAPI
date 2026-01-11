package com.example.employeeapi.service;

import com.example.employeeapi.security.JwtUtil;
import com.example.employeeapi.dto.LoginRequest;
import com.example.employeeapi.dto.LoginResponse;

import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(LoginRequest request) {

        if (request.getEmail().equals("admin")
                && request.getPassword().equals("admin123")) {

            String token = jwtUtil.generateToken(request.getEmail(), "ROLE_ADMIN");
            return new LoginResponse(token);
        }

        if (request.getEmail().equals("user.com")
                && request.getPassword().equals("user123")) {

            String token = jwtUtil.generateToken(request.getEmail(), "ROLE_USER");
            return new LoginResponse(token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
