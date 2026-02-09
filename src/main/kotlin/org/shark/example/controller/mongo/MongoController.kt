package org.shark.example.controller.mongo

import org.shark.example.datasource.mongo.pojo.ExampleDo
import org.shark.example.service.mongo.MongoCreateService
import org.shark.example.service.mongo.MongoReadService
import org.shark.example.service.pojo.ResponseDto
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mongo")
class MongoController(
    private val mongoCreateService: MongoCreateService,
    private val mongoReadService: MongoReadService
) {

    private val log = LoggerFactory.getLogger(MongoController::class.java)

    @PostMapping
    fun create(@RequestBody exampleDo: ExampleDo): ResponseDto<Void> {
        return mongoCreateService.start(exampleDo)
    }

    @GetMapping
    fun read(): ResponseDto<List<ExampleDo>> {
        return mongoReadService.start()
    }
}
