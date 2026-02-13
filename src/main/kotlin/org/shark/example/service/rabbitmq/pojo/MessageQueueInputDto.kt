package org.shark.example.service.rabbitmq.pojo

import java.io.Serializable

data class MessageQueueInputDto(
    var data: String? = null
) : Serializable
