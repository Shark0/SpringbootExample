package org.shark.example.service.rabbitmq

import com.google.gson.Gson
import org.shark.example.service.rabbitmq.pojo.MessageQueueDto
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitMqListener {
    private val log = LoggerFactory.getLogger(RabbitMqListener::class.java)

    @RabbitListener(queues = ["example"], containerFactory = "exampleContainerFactory")
    fun receiveMessage(message: MessageQueueDto) {
        log.info("message: {}", Gson().toJson(message))
    }
}
