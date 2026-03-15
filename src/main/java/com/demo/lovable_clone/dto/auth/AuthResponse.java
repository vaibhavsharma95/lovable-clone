package com.demo.lovable_clone.dto.auth;

public record AuthResponse(String token, UserProfileResponse user) {
}


// new AuthResponse("", new UserProfileResponse());