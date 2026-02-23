package org.shark.example.service.emqx

import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.mqtt.MqttUseCase
import org.springframework.stereotype.Service
import org.slf4j.LoggerFactory

@Service
class SendMessageService(
    private val mqttUseCase: MqttUseCase
) {
    private val log = LoggerFactory.getLogger(SendMessageService::class.java)

    fun start(message: String): ResponseDto<Void> {
        mqttUseCase.pushMessage(message)
        return ResponseDto(
            status = true
        )
    }
}
