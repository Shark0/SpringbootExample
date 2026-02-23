package org.shark.example.service.cassandra.pojo

import jakarta.validation.constraints.NotNull

data class SaveAccountDto(
    @field:NotNull
    var account: String? = null,
    @field:NotNull
    var password: String? = null
)
