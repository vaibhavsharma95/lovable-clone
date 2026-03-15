package com.demo.lovable_clone.service.impl;

import com.demo.lovable_clone.dto.auth.AuthResponse;
import com.demo.lovable_clone.dto.auth.LoginRequest;
import com.demo.lovable_clone.dto.auth.SignupRequest;
import com.demo.lovable_clone.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse signup(SignupRequest signupRequest) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }
}
