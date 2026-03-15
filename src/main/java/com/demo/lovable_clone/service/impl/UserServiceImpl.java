package com.demo.lovable_clone.service.impl;

import com.demo.lovable_clone.dto.auth.UserProfileResponse;
import com.demo.lovable_clone.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
