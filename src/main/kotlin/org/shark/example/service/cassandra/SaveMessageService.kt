package org.shark.example.service.cassandra

import org.shark.example.datasource.cassandra.pojo.MessageDo
import org.shark.example.datasource.cassandra.pojo.MessageKeyDo
import org.slf4j.LoggerFactory
import org.springframework.data.cassandra.core.CassandraTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class SaveMessageService(
    private val cassandraTemplate: CassandraTemplate
) {
    private val log = LoggerFactory.getLogger(SaveMessageService::class.java)

    fun saveMessage() {
        val userCount: Long = 100
        val messageCount: Long = 10

        val messageList = ArrayList<MessageDo>()
        for (i in 0 until userCount) {
            for (j in 0 until messageCount) {
                val messageDo = MessageDo()
                val messageKeyDo = MessageKeyDo()
                messageKeyDo.userId = i
                messageKeyDo.userService = "CUSTOMER"
                messageKeyDo.itemId = j
                messageDo.messageKey = messageKeyDo
                messageDo.time = Date()
                messageList.add(messageDo)
            }
        }
        val startTime = System.currentTimeMillis()

        cassandraTemplate.batchOps().insert(messageList).execute()

        val endTime = System.currentTimeMillis()
        log.info("total save time: {} ms", (endTime - startTime))
    }
}
