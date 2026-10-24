package com.serviliocaicedo.turnie.auth;

import com.serviliocaicedo.turnie.user.Role;
import com.serviliocaicedo.turnie.user.User;
import com.serviliocaicedo.turnie.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse register(RegisterRequest request) {
        if (request.role() == Role.ADMIN) {
            throw new InvalidRegistrationException("No se puede registrar una cuenta con ese rol");
        }

        String email = request.email().trim().toLowerCase();
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException(email);
        }

        User user = User.builder()
                .name(request.name().trim())
                .email(email)
                .passwordHash(passwordEncoder.encode(request.password()))
                .phone(request.phone())
                .role(request.role())
                .build();

        return UserResponse.from(userRepository.save(user));
    }
}