package org.shark.example.dao.repository

import org.shark.example.dao.repository.pojo.JsonJoinExampleDo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JsonJoinExampleRepository : JpaRepository<JsonJoinExampleDo, Int>
