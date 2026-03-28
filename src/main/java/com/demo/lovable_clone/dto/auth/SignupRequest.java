package com.demo.lovable_clone.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignupRequest (
        @NotBlank String name,
        @NotBlank String username,
        @Size(min = 4, max=8) String password){
}
