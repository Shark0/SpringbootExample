package org.shark.example.dao.repository;

import org.shark.example.dao.repository.pojo.TaskHistoryDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskHistoryRepository extends JpaRepository<TaskHistoryDo, Integer> {

    @Query(value = "select * from TASK_HISTORY order by id desc limit :size offset :offset", nativeQuery = true)
    List<TaskHistoryDo> findByPage(Integer size, Integer offset);
}
