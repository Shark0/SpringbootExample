package org.shark.example.service.cassandra

import org.shark.example.datasource.cassandra.MessageRepository
import org.shark.example.datasource.cassandra.pojo.MessageDo
import org.springframework.stereotype.Service

@Service
class GetMessageListService(
    private val messageRepository: MessageRepository
) {

    fun getAccountList(): List<MessageDo> {
        return messageRepository.findAll()
    }
}
