package org.shark.example.service.base.pojo

data class ResponseDto<ResultData>(
    var status: Boolean? = null,
    var data: ResultData? = null,
    var errorMessage: String? = null
) {
    companion object {
        fun <ResultData> builder(): Builder<ResultData> {
            return Builder()
        }
    }

    class Builder<ResultData> {
        private var status: Boolean? = null
        private var data: ResultData? = null
        private var errorMessage: String? = null

        fun status(status: Boolean?): Builder<ResultData> {
            this.status = status
            return this
        }

        fun data(data: ResultData?): Builder<ResultData> {
            this.data = data
            return this
        }

        fun errorMessage(errorMessage: String?): Builder<ResultData> {
            this.errorMessage = errorMessage
            return this
        }

        fun build(): ResponseDto<ResultData> {
            return ResponseDto(status, data, errorMessage)
        }
    }
}
