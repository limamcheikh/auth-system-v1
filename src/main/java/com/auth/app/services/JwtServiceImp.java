package com.auth.app.services;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

import javax.crypto.SecretKey;

@Service
public class JwtServiceImp implements JwtService {
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private long expiration;
    
    @Value("${jwt.refresh-expiration}")
    private long refreshExpiration;
    
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
    
    @Override
    public String generateToken(String username) {
        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey())
            .compact();
    }
    
    @Override
    public String generateRefreshToken(String username) {
        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + refreshExpiration))
            .signWith(getSigningKey())
            .compact();
    }
    
    @Override
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }
    
    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .verifyWith(getSigningKey())  // Use verifyWith() instead of setSigningKey()
                .build()
                .parseSignedClaims(token);    // Use parseSignedClaims() instead of parseClaimsJws()
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
    
    @Override
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())  // Use verifyWith() instead of setSigningKey()
                .build()
                .parseSignedClaims(token)      // Use parseSignedClaims() instead of parseClaimsJws()
                .getPayload();  
    }
    
    @Override
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
