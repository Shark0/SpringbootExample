package org.shark.example.service.rabbitmq

import jakarta.annotation.Resource
import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.rabbitmq.pojo.MessageQueueDto
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SendRabbitMessageQueueService {
    @Resource(name = "exampleRabbitTemplate")
    private lateinit var rabbitTemplate: RabbitTemplate

    fun start(messageQueueInputDto: MessageQueueInputDto): ResponseDto<Void> {
        val messageQueueDto = MessageQueueDto()
        messageQueueDto.uuid = UUID.randomUUID().toString()
        messageQueueDto.data = messageQueueInputDto.data
        rabbitTemplate.convertAndSend("example", messageQueueDto)
        return ResponseDto.builder<Void>().status(true).build()
    }
}
