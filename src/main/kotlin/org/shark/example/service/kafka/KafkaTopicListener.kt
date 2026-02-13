package org.shark.example.service.kafka

import io.github.oshai.kotlinlogging.KotlinLogging
import org.shark.example.service.rabbitmq.pojo.MessageQueueDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class KafkaTopicListener {

    @KafkaListener(topics = ["message_topic"], groupId = "1", batch = "true")
    fun messageTopicListener(messageList: MutableList<String?>) {
        log.info("messageList.size() = {}", messageList.size)
        for (message in messageList) {
            log.info { "message = $message" };
        }
    }

    @KafkaListener(topics = ["json_topic"], groupId = "2", batch = "true")
    fun jsonTopicListener(messageQueueDtoList: MutableList<MessageQueueDto?>) {
        for (messageQueueDto in messageQueueDtoList) {
            log.info {"messageQueueDto = $messageQueueDto"}
        }
    }
}