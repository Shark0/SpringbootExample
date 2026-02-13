package org.shark.example.controller.kafka

import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.kafka.PushKafkaJsonQueueService
import org.shark.example.service.kafka.PushKafkaMessageQueueService
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/kafka"])
class KafkaController(
    private val pushKafkaMessageQueueService: PushKafkaMessageQueueService,
    private val pushKafkaJsonQueueService: PushKafkaJsonQueueService
) {

    @PostMapping("/pushMessage")
    fun pushMessage(@RequestBody messageQueueInputDto: MessageQueueInputDto): ResponseDto<Void> {
        return pushKafkaMessageQueueService.start(messageQueueInputDto)
    }

    @PostMapping("/pushJson")
    fun pushJson(@RequestBody messageQueueInputDto: MessageQueueInputDto): ResponseDto<Void> {
        return pushKafkaJsonQueueService.start(messageQueueInputDto)
    }
}
