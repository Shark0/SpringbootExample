package org.shark.example.domain.user.model;

public interface UserRepository {
    void save(UserDto user);
    boolean existsByEmail(String email);
}
