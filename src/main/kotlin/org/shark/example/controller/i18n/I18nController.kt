package org.shark.example.controller.i18n

import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.i18n.GetI18nService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/i18n")
class I18nController(private val getI18nService: GetI18nService) {

    private val log = LoggerFactory.getLogger(I18nController::class.java)

    @GetMapping
    fun getMessage(@RequestParam value1: String, @RequestParam value2: Int): ResponseDto<String> {
        return getI18nService.start(value1, value2)
    }
}
