package org.shark.example.service.mysql

import org.shark.example.dao.repository.TaskHistoryRepository
import org.shark.example.dao.repository.pojo.TaskHistoryDo
import org.springframework.stereotype.Service

@Service
class FindTaskHistoryService(
    private val taskHistoryRepository: TaskHistoryRepository
) {
    fun start(page: Int, size: Int): List<TaskHistoryDo> {
        val offset = page * size
        return taskHistoryRepository.findByPage(size, offset)
    }
}
