package org.shark.example.service.cassandra

import org.shark.example.datasource.cassandra.pojo.MessageDo
import org.slf4j.LoggerFactory
import org.springframework.data.cassandra.core.CassandraTemplate
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class SaveMessageTask(
    private val cassandraTemplate: CassandraTemplate
) {
    private val log = LoggerFactory.getLogger(SaveMessageTask::class.java)

    @Async
    fun start(messageList: List<MessageDo>): CompletableFuture<Boolean> {
        val saveStartTime = System.currentTimeMillis()
        try {
            cassandraTemplate.batchOps().insert(messageList).execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val saveEndTime = System.currentTimeMillis()
        log.info("save time: {} ms", saveEndTime - saveStartTime)
        return CompletableFuture.completedFuture(true)
    }
}
