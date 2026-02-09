package org.shark.example.service.cassandra

import org.shark.example.datasource.cassandra.pojo.MessageDo
import org.shark.example.datasource.cassandra.pojo.MessageKeyDo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.CompletableFuture

@Service
class SaveMessageByAsyncService(
    private val saveMessageTask: SaveMessageTask
) {
    private val log = LoggerFactory.getLogger(SaveMessageByAsyncService::class.java)

    fun saveMessage() {
        val userCount: Long = 10000
        val messageCount: Long = 1
        val resultList = ArrayList<CompletableFuture<Boolean>>()
        val startTime = System.currentTimeMillis()
        var messageList = ArrayList<MessageDo>()
        for (i in 0 until userCount) {
            for (j in 0 until messageCount) {
                val messageDo = MessageDo()
                val messageKeyDo = MessageKeyDo()
                messageKeyDo.userId = i
                messageKeyDo.userService = "CHIT_CHAT"
                messageKeyDo.itemId = j
                messageDo.messageKey = messageKeyDo
                messageDo.time = Date()
                messageList.add(messageDo)
                if (messageList.size == 500) {
                    resultList.add(saveMessageTask.start(messageList))
                    messageList = ArrayList()
                }
            }
        }
        CompletableFuture.allOf(*resultList.toTypedArray()).join()
        val endTime = System.currentTimeMillis()
        log.info("total save time: {} ms", (endTime - startTime))
    }
}
