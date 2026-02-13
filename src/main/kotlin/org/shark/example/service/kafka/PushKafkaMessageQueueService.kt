package org.shark.example.service.kafka

import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class PushKafkaMessageQueueService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    private val log = LoggerFactory.getLogger(PushKafkaMessageQueueService::class.java)

    fun start(messageQueueInputDto: MessageQueueInputDto): ResponseDto<Void> {
        val batchSize = 10000
        val message = messageQueueInputDto.data
        val startTime = System.currentTimeMillis()
        for (i in 0 until batchSize) {
            kafkaTemplate.send("message_topic", message + i)
        }
        val endTime = System.currentTimeMillis()
        log.info("total time = {}", endTime - startTime)
        return ResponseDto(status = true)
    }
}
