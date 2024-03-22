package org.shark.example.dao.repository;

import org.shark.example.dao.repository.pojo.TaskDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends JpaRepository<TaskDo, Integer> {

    TaskDo findByWorkId(String workId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TASK SET WORK_ID = :workId WHERE STATUS = 0 AND WORK_ID is null limit 1", nativeQuery = true)
    void updateWorkId(String workId);
}
