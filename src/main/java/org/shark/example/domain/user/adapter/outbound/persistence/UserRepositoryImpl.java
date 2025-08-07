package org.shark.example.domain.user.adapter.outbound.persistence;

import lombok.RequiredArgsConstructor;
import org.shark.example.domain.user.model.UserDto;
import org.shark.example.domain.user.model.UserRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public void save(UserDto user) {
        UserDo userDo = new UserDo();
        userDo.setId(user.getId());
        userDo.setName(user.getName());
        userDo.setEmail(user.getEmail());
        userJpaRepository.save(userDo);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }
}
