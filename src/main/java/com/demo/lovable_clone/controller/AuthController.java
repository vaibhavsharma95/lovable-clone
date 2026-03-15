package com.demo.lovable_clone.controller;

import com.demo.lovable_clone.dto.auth.AuthResponse;
import com.demo.lovable_clone.dto.auth.LoginRequest;
import com.demo.lovable_clone.dto.auth.SignupRequest;
import com.demo.lovable_clone.dto.auth.UserProfileResponse;
import com.demo.lovable_clone.service.AuthService;
import com.demo.lovable_clone.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE) // Adding this makes both authservice & userService and all other fields private final by default
public class AuthController {

    /*private final AuthService authService;
    private final UserService userService;*/

    AuthService authService;
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signupRequest(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
