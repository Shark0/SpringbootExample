package org.shark.example.controller

import org.shark.example.service.base.pojo.ResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping
    fun get(): ResponseDto<Void> {
        return ResponseDto.builder<Void>().status(true).build()
    }
}
