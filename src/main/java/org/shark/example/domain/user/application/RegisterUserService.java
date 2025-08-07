package org.shark.example.domain.user.application;

import lombok.RequiredArgsConstructor;
import org.shark.example.domain.user.model.UserDto;
import org.shark.example.domain.user.model.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserRepository userRepository;

    public void register(String name, String email) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already used.");
        }
        UserDto user = new UserDto(UUID.randomUUID().toString(), name, email);
        userRepository.save(user);
    }
}
