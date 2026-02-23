package org.shark.example.config.event

import org.springframework.integration.annotation.MessagingGateway
import org.springframework.integration.mqtt.support.MqttHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
@MessagingGateway(defaultRequestChannel = "mqttOutputChannel")
interface MqttGateway {
    @Async("mqttPublish")
    fun publish(@Header(MqttHeaders.TOPIC) topic: String, payload: String)
}
