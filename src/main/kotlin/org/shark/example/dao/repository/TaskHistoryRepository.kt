package org.shark.example.dao.repository

import org.shark.example.dao.repository.pojo.TaskHistoryDo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TaskHistoryRepository : JpaRepository<TaskHistoryDo, Int> {

    @Query(value = "select * from TASK_HISTORY order by id desc limit :size offset :offset", nativeQuery = true)
    fun findByPage(size: Int, offset: Int): List<TaskHistoryDo>
}
