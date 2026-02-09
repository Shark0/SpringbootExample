package org.shark.example.service.base.pojo

data class ResponseDto<ResultData>(
    val status: Boolean? = null,
    val data: ResultData? = null,
    val errorMessage: String? = null
)
