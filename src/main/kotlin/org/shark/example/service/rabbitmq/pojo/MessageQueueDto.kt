package org.shark.example.service.rabbitmq.pojo

import java.io.Serializable

class MessageQueueDto : Serializable {
    var uuid: String? = null
    var data: String? = null
}
