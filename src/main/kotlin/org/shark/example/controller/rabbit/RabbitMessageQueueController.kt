package org.shark.example.controller.rabbit

import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.rabbitmq.SendRabbitMessageQueueService
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rabbit-mq")
class RabbitMessageQueueController(
    private val sendRabbitMessageQueueService: SendRabbitMessageQueueService
) {
    private val log = LoggerFactory.getLogger(RabbitMessageQueueController::class.java)

    @PostMapping("/send")
    fun send(@RequestBody messageQueueInputDto: MessageQueueInputDto): ResponseDto<Void> {
        return sendRabbitMessageQueueService.start(messageQueueInputDto)
    }
}
