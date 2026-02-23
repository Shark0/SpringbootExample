package org.shark.example.service.base.async

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.CompletableFuture

@Service
class AsyncTask2 {

    private val log = LoggerFactory.getLogger(AsyncTask2::class.java)

    @Async("taskExecutor2")
    fun start(value1: String): CompletableFuture<String> {
        val time = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        log.info("time = {}", time)
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
        return CompletableFuture.completedFuture("AsyncTask1 value = $value1")
    }
}
