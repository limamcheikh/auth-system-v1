package com.auth.app.controller;


import com.auth.app.dto.*;
import com.auth.app.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> signin(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
    
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(authService.register(request));
    }
    
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(@RequestParam String token) {
        return ResponseEntity.ok(authService.refreshToken(token));
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam String token) {
        authService.logout(token);
        return ResponseEntity.ok("Logged out successfully");
    }
}
