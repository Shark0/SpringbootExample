package org.shark.example.domain.user.model

interface UserRepository {
    fun save(user: UserDto)
    fun existsByEmail(email: String): Boolean
}
