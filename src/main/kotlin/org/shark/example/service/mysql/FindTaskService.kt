package org.shark.example.service.mysql

import org.shark.example.dao.repository.TaskRepository
import org.shark.example.dao.repository.pojo.TaskDo
import org.springframework.stereotype.Service

@Service
class FindTaskService(
    private val taskRepository: TaskRepository
) {
    fun start(page: Int, size: Int): List<TaskDo> {
        val offset = page * size
        return taskRepository.findByPage(size, offset)
    }
}
