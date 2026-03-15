package com.demo.lovable_clone.service;

import com.demo.lovable_clone.dto.auth.AuthResponse;
import com.demo.lovable_clone.dto.auth.LoginRequest;
import com.demo.lovable_clone.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest signupRequest);

    AuthResponse login(LoginRequest loginRequest);
}
