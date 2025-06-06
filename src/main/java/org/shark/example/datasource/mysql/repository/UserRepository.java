package org.shark.example.datasource.mysql.repository;

import org.shark.example.datasource.mysql.pojo.UserDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDo, Long> {

}
