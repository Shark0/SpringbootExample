package org.shark.example.controller.mysql.pojo

import org.shark.example.service.mysql.pojo.CreateJsonExampleDto

data class JsonInnerJoinDto(
    var id: Int? = null,
    var createJsonExampleDto: CreateJsonExampleDto? = null,
    var description: String? = null
)
