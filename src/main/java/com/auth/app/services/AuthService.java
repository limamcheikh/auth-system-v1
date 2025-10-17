package com.auth.app.services;

import com.auth.app.dto.LoginRequest;
import com.auth.app.dto.LoginResponse;
import com.auth.app.dto.RegisterRequest;
import com.auth.app.dto.RegisterResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
    RegisterResponse register(RegisterRequest request);
    LoginResponse refreshToken(String token);
    void logout(String token);
}