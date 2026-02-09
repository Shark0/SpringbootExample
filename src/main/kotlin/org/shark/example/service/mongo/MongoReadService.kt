package org.shark.example.service.mongo

import org.shark.example.datasource.mongo.ExampleRepository
import org.shark.example.datasource.mongo.pojo.ExampleDo
import org.shark.example.service.pojo.ResponseDto
import org.springframework.stereotype.Service

@Service
class MongoReadService(
    private val exampleRepository: ExampleRepository
) {

    fun start(): ResponseDto<List<ExampleDo>> {
        return ResponseDto(status = true, data = exampleRepository.findAll())
    }
}
