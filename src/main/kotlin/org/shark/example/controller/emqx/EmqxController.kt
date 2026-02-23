package org.shark.example.controller.emqx

import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.emqx.SendMessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/emqx")
class EmqxController(
    private val sendMessageService: SendMessageService
) {
    private val log = LoggerFactory.getLogger(EmqxController::class.java)

    @GetMapping
    fun getMessage(@RequestParam message: String): ResponseDto<Void> {
        return sendMessageService.start(message)
    }
}
