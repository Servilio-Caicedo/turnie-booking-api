package com.serviliocaicedo.turnie.auth;

import com.serviliocaicedo.turnie.user.Role;
import com.serviliocaicedo.turnie.user.User;

public record UserResponseDto(Long id, String name, String email, String phone, Role role) {
    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(),
                user.getPhone(), user.getRole());
    }
}