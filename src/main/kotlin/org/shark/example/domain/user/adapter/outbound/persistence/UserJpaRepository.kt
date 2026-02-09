package org.shark.example.domain.user.adapter.outbound.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<UserDo, String> {
    fun existsByEmail(email: String): Boolean
}
