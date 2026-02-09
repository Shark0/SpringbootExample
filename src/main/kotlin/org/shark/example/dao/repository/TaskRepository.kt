package org.shark.example.dao.repository

import org.shark.example.dao.repository.pojo.TaskDo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface TaskRepository : JpaRepository<TaskDo, Int> {

    fun findByWorkId(workId: String): TaskDo?

    @Transactional
    @Modifying
    @Query(value = "UPDATE TASK SET WORK_ID = :workId WHERE STATUS = 0 AND WORK_ID is null limit 1", nativeQuery = true)
    fun updateWorkId(workId: String)

    @Query(value = "select * from TASK order by id desc limit :size offset :offset", nativeQuery = true)
    fun findByPage(size: Int, offset: Int): List<TaskDo>
}
