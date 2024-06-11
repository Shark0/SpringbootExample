package org.shark.example.dao.repository;

import org.shark.example.dao.repository.pojo.JsonJoinExampleDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonJoinExampleRepository extends JpaRepository<JsonJoinExampleDo, Integer> {
    
}
