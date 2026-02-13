package org.shark.example.service.kafka

import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.rabbitmq.pojo.MessageQueueDto
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class PushKafkaJsonQueueService(
    private val kafkaTemplate: KafkaTemplate<String, MessageQueueDto>
) {
    fun start(messageQueueInputDto: MessageQueueInputDto): ResponseDto<Void> {
        val messageQueueDto = MessageQueueDto(
            data = messageQueueInputDto.data,
            uuid = UUID.randomUUID().toString()
        )
        kafkaTemplate.send("json_topic", messageQueueDto)
        return ResponseDto(status = true)
    }
}
