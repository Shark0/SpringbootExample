package org.shark.example.dao.repository;

import org.shark.example.dao.repository.pojo.WorkHistoryDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkHistoryRepository extends JpaRepository<WorkHistoryDo, Integer> {
}
