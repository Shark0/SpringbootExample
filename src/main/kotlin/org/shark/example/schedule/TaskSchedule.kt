package org.shark.example.schedule

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*

@Component
class TaskSchedule {

    private val log = LoggerFactory.getLogger(TaskSchedule::class.java)

    @Scheduled(initialDelay = 1, fixedRate = 1)
    fun doTask() {
        log.info("start time: " + SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
    }
}
