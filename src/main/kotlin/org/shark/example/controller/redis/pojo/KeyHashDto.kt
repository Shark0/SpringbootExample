package org.shark.example.controller.redis.pojo

data class KeyHashDto(
    val key: String? = null,
    val value: Map<String, String>? = null
)
