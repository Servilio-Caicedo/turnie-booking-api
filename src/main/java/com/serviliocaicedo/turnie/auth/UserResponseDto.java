package com.serviliocaicedo.turnie.auth;

import com.serviliocaicedo.turnie.user.Role;
import com.serviliocaicedo.turnie.user.User;

public record UserResponse(Long id, String name, String email, String phone, Role role) {
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(),
                user.getPhone(), user.getRole());
    }
}