package org.shark.example.domain.user.adapter.outbound.persistence

import org.shark.example.domain.user.model.UserDto
import org.shark.example.domain.user.model.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {

    override fun save(user: UserDto) {
        val userDo = UserDo()
        userDo.id = user.id
        userDo.name = user.name
        userDo.email = user.email
        userJpaRepository.save(userDo)
    }

    override fun existsByEmail(email: String): Boolean {
        return userJpaRepository.existsByEmail(email)
    }
}
