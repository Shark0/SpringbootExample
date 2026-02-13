package org.shark.example.service.rabbitmq.pojo

import java.io.Serializable

data class MessageQueueDto(
    var uuid: String? = null,
    var data: String? = null
) : Serializable
