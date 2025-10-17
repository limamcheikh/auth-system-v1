package com.auth.app.services;

import io.jsonwebtoken.Claims;

public interface JwtService {
    String generateToken(String username);
    String generateRefreshToken(String username);
    String extractUsername(String token);
    boolean validateToken(String token);
    Claims extractAllClaims(String token);
    boolean isTokenExpired(String token);
}
