package org.shark.example.dao.repository;

import org.shark.example.dao.repository.pojo.JsonExampleDo;
import org.shark.example.dao.repository.pojo.JsonInnerJoinDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JsonExampleRepository extends JpaRepository<JsonExampleDo, Integer> {

    @Query(value = "select JE.ID as id, JE.JSON_DATA as jsonData, JJE.DESCRIPTION as description " +
            "from JSON_EXAMPLE JE " +
            "INNER JOIN JSON_JOIN_EXAMPLE JJE on JE.ID = JJE.JSON_EXAMPLE_ID", nativeQuery = true)
    public List<JsonInnerJoinDo> findAllJoin();
}
