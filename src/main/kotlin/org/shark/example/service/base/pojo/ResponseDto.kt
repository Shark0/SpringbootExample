package org.shark.example.service.base.pojo

data class ResponseDto<T>(
    val status: Boolean? = null,
    val data: T? = null,
    val errorMessage: String? = null
)
