package org.shark.example.domain.user.adapter.outbound.persistence

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "USER")
@Entity
data class UserDo(
    @Id
    var id: String? = null,
    var name: String? = null,
    var email: String? = null
)
