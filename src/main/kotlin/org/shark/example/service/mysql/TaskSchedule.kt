package org.shark.example.service.mysql

import org.shark.example.dao.repository.TaskHistoryRepository
import org.shark.example.dao.repository.TaskRepository
import org.shark.example.dao.repository.pojo.TaskDo
import org.shark.example.dao.repository.pojo.TaskHistoryDo
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TaskSchedule(
    private val taskRepository: TaskRepository,
    private val taskHistoryRepository: TaskHistoryRepository
) {
    private val log = LoggerFactory.getLogger(TaskSchedule::class.java)

    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    fun doTask() {
        val workId = UUID.randomUUID().toString()
        taskRepository.updateWorkId(workId)
        val taskDo: TaskDo? = taskRepository.findByWorkId(workId)
        if (taskDo == null) {
            return
        }
        taskDo.status = 1
        taskRepository.save(taskDo)
        val taskHistoryDo = TaskHistoryDo()
        taskHistoryDo.taskId = taskDo.id
        taskHistoryDo.workId = workId
        taskHistoryDo.status = 1
        taskHistoryRepository.save(taskHistoryDo)
    }
}
