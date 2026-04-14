package com.shopsy.auth.controller;

import com.shopsy.auth.dto.AuthResponse;
import com.shopsy.auth.dto.LoginRequest;
import com.shopsy.auth.dto.SignupRequest;
import com.shopsy.auth.dto.SignupResponse;
import com.shopsy.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public SignupResponse signup(@Valid @RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/health")
    public String health() {
        return "auth-service-ok";
    }
}
