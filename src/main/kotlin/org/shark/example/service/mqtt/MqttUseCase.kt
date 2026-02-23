package org.shark.example.service.mqtt

import org.shark.example.config.event.MqttGateway
import org.springframework.context.event.EventListener
import org.springframework.core.annotation.Order
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.slf4j.LoggerFactory

@Order(0)
@Component
class MqttUseCase(
    private val mqttGateway: MqttGateway
) {
    private val log = LoggerFactory.getLogger(MqttUseCase::class.java)

    @Async("eventTaskExecutor")
    @EventListener
    fun pushMessage(message: String) {
        val emqxMessage = """{"message": "$message"}"""
        log.info("emqx message: {}", emqxMessage)
        mqttGateway.publish("test", emqxMessage)
    }
}
