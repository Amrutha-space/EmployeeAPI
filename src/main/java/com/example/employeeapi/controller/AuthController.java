package com.example.employeeapi.controller;

import com.example.employeeapi.dto.LoginRequest;
import com.example.employeeapi.entity.User;
import com.example.employeeapi.repository.UserRepository;
import com.example.employeeapi.security.JwtUtil;
import com.example.employeeapi.response.ApiResponse;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwt;

    public AuthController(UserRepository repo, PasswordEncoder encoder, JwtUtil jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public ApiResponse<Map<String,String>> login(@RequestBody LoginRequest req) {
        System.out.println("LOGIN API HIT");

        User user = repo.findByUsername(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(req.getPassword(), user.getPassword()))
            throw new RuntimeException("Invalid password");

        String token = jwt.generateToken(user.getUsername(), user.getRole());

        return ApiResponse.success(Map.of(
                "token", token,
                "role", user.getRole()
        ));
    }

    // 🔹 TEMPORARY: Create test users in DB
    @GetMapping("/create-test-users")
    public String createTestUsers() {

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(encoder.encode("admin123"));
        admin.setRole("ROLE_ADMIN");
        repo.save(admin);

        User user = new User();
        user.setUsername("user");
        user.setPassword(encoder.encode("user123"));
        user.setRole("ROLE_USER");
        repo.save(user);

        return "Test users created";
    }
}
