package org.shark.example.datasource.mongo.pojo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class ExampleDo(
    @Id
    var id: String? = null,
    var map: Map<String, String>? = null,
    var list: List<String>? = null
)
