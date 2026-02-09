package org.shark.example.service.mysql

import org.shark.example.dao.repository.JsonJoinExampleRepository
import org.shark.example.dao.repository.pojo.JsonJoinExampleDo
import org.shark.example.service.mysql.pojo.CreateJsonJoinExampleDto
import org.springframework.stereotype.Service

@Service
class CreateJsonJoinExampleService(
    private val jsonJoinExampleRepository: JsonJoinExampleRepository
) {
    fun createJsonExample(createJsonJoinExampleDto: CreateJsonJoinExampleDto) {
        val jsonJoinExampleDo = JsonJoinExampleDo()
        jsonJoinExampleDo.jsonExampleId = createJsonJoinExampleDto.jsonExampleId
        jsonJoinExampleDo.description = createJsonJoinExampleDto.description
        jsonJoinExampleRepository.save(jsonJoinExampleDo)
    }
}
