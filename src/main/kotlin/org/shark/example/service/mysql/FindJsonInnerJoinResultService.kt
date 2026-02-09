package org.shark.example.service.mysql

import com.google.gson.Gson
import org.shark.example.controller.mysql.pojo.JsonInnerJoinDto
import org.shark.example.dao.repository.JsonExampleRepository
import org.shark.example.service.mysql.pojo.CreateJsonExampleDto
import org.springframework.stereotype.Service

@Service
class FindJsonInnerJoinResultService(
    private val jsonExampleRepository: JsonExampleRepository
) {
    fun start(): List<JsonInnerJoinDto> {
        val gson = Gson()
        val jsonInnerJoinDoList = jsonExampleRepository.findAllJoin()
        val list = ArrayList<JsonInnerJoinDto>()
        for (jsonInnerJoinDo in jsonInnerJoinDoList) {
            val jsonInnerJoinDto = JsonInnerJoinDto()
            jsonInnerJoinDto.id = jsonInnerJoinDo.id
            jsonInnerJoinDto.description = jsonInnerJoinDo.description
            jsonInnerJoinDto.createJsonExampleDto = gson.fromJson(jsonInnerJoinDo.jsonData, CreateJsonExampleDto::class.java)
            list.add(jsonInnerJoinDto)
        }
        return list
    }
}
