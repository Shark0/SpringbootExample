package org.shark.example.domain.user.application

import org.shark.example.domain.user.model.UserDto
import org.shark.example.domain.user.model.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class RegisterUserService(
    private val userRepository: UserRepository
) {
    fun register(name: String, email: String) {
        if (userRepository.existsByEmail(email)) {
            throw IllegalArgumentException("Email already used.")
        }
        val user = UserDto(UUID.randomUUID().toString(), name, email)
        userRepository.save(user)
    }
}
