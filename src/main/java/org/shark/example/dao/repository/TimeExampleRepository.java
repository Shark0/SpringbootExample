package org.shark.example.dao.repository;

import org.shark.example.dao.repository.pojo.TimeExampleDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeExampleRepository extends JpaRepository<TimeExampleDo, Long> {
}
