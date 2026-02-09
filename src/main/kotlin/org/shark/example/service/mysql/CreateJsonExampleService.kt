package org.shark.example.service.mysql

import com.google.gson.Gson
import org.shark.example.dao.repository.JsonExampleRepository
import org.shark.example.dao.repository.pojo.JsonExampleDo
import org.shark.example.service.mysql.pojo.CreateJsonExampleDto
import org.springframework.stereotype.Service

@Service
class CreateJsonExampleService(
    private val jsonExampleRepository: JsonExampleRepository
) {
    fun createJsonExample(createJsonExampleDto: CreateJsonExampleDto) {
        val jsonData = Gson().toJson(createJsonExampleDto)
        val jsonExampleDo = JsonExampleDo()
        jsonExampleDo.jsonData = jsonData
        jsonExampleRepository.save(jsonExampleDo)
    }
}
