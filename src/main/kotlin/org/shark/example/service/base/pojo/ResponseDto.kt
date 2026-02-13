package org.shark.example.service.base.pojo

data class ResponseDto<ResultData>(
    var status: Boolean? = null,
    var data: ResultData? = null,
    var errorMessage: String? = null
) {
    companion object {
        fun <ResultData> builder() = Builder<ResultData>()
    }

    class Builder<ResultData> {
        private var status: Boolean? = null
        private var data: ResultData? = null
        private var errorMessage: String? = null

        fun status(status: Boolean?) = apply { this.status = status }
        fun data(data: ResultData?) = apply { this.data = data }
        fun errorMessage(errorMessage: String?) = apply { this.errorMessage = errorMessage }
        fun build() = ResponseDto(status, data, errorMessage)
    }
}
