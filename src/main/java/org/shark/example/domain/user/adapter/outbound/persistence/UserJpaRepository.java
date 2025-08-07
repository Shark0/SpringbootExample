package org.shark.example.domain.user.adapter.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserDo, String> {
    boolean existsByEmail(String email);
}
