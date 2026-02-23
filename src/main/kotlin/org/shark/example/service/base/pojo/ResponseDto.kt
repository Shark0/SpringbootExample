package org.shark.example.service.base.pojo

data class ResponseDto<T>(
    var status: Boolean? = null,
    var data: T? = null,
    var errorMessage: String? = null
)
