package org.shark.example.service.mongo

import org.shark.example.datasource.mongo.ExampleRepository
import org.shark.example.datasource.mongo.pojo.ExampleDo
import org.shark.example.service.pojo.ResponseDto
import org.springframework.stereotype.Service

@Service
class MongoCreateService(
    private val exampleRepository: ExampleRepository
) {

    fun start(exampleDo: ExampleDo): ResponseDto<Void> {
        exampleRepository.save(exampleDo)
        return ResponseDto(status = true)
    }
}
