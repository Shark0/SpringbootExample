package org.shark.example.service.base.pojo

data class ResponseDto<ResultData>(
    var status: Boolean? = null,
    var data: ResultData? = null,
    var errorMessage: String? = null
)
