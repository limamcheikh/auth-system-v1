package com.auth.app.services;

import com.auth.app.dto.LoginRequest;
import com.auth.app.dto.LoginResponse;
import com.auth.app.dto.RegisterRequest;
import com.auth.app.dto.RegisterResponse;
import com.auth.app.dto.UserDto;
import com.auth.app.models.User;
import com.auth.app.models.Role;
import com.auth.app.ripository.UserRepository;

import com.auth.app.services.JwtService;
import com.auth.app.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private UserRepository userRepository;
    
    public AuthServiceImpl(UserService userService, AuthenticationManager authenticationManager,
                         JwtService jwtService, UserRepository userRepository) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }
    
    @Override
    public LoginResponse login(LoginRequest request) {
    	
    	
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );
        
       
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
        if (!userOpt.isPresent()) {
            throw new RuntimeException("User not found");
        }
        User user = userOpt.get();
        
        String token = jwtService.generateToken(request.getUsername());
        String refreshToken = jwtService.generateRefreshToken(request.getUsername());
        
        Set<String> roles = new HashSet<>();
        for (Role role : user.getRoles()) {
            roles.add(role.getName());
        }
        
        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setRefreshToken(refreshToken);
        response.setUsername(user.getUsername());
        response.setRoles(roles);
        response.setExpiresIn(3600000L);
        
        return response;
    }
    
    @Override
    public RegisterResponse register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }
        
        UserDto user = userService.createUser(request);
        
        RegisterResponse response = new RegisterResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setSuccess(true);
        response.setMessage("User registered successfully");
        
        return response;
    }
    
    @Override
    public LoginResponse refreshToken(String token) {
        if (!jwtService.validateToken(token)) {
            throw new RuntimeException("Invalid refresh token");
        }
        
        String username = jwtService.extractUsername(token);
        String newToken = jwtService.generateToken(username);
        
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (!userOpt.isPresent()) {
            throw new RuntimeException("User not found");
        }
        User user = userOpt.get();
        
        Set<String> roles = new HashSet<>();
        for (Role role : user.getRoles()) {
            roles.add(role.getName());
        }
        
        LoginResponse response = new LoginResponse();
        response.setToken(newToken);
        response.setRefreshToken(token);
        response.setUsername(username);
        response.setRoles(roles);
        response.setExpiresIn(3600000L);
        
        return response;
    }
    
    @Override
    public void logout(String token) {
       
    }
}

