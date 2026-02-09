package org.shark.example.service.mysql

import org.shark.example.dao.repository.TaskRepository
import org.shark.example.dao.repository.pojo.TaskDo
import org.shark.example.service.mysql.pojo.CreateTaskDto
import org.springframework.stereotype.Service

@Service
class CreateTaskService(
    private val taskRepository: TaskRepository
) {
    fun start(createTaskDto: CreateTaskDto) {
        val taskDo = TaskDo()
        taskDo.status = 0
        taskDo.name = createTaskDto.name
        taskRepository.save(taskDo)
    }
}
