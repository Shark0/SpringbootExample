package org.shark.example.dao.repository;

import org.shark.example.dao.repository.pojo.TaskDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends JpaRepository<TaskDo, Integer> {

    TaskDo findByCheckId(String uuid);


    @Transactional
    @Modifying
    @Query(value = "UPDATE TASK SET CHECK_ID = :checkId WHERE STATUS = 0 AND CHECK_ID is null limit 1", nativeQuery = true)
    void updateCheckId(String checkId);
}
