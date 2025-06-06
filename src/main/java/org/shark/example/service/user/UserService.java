package org.shark.example.service.user;

import lombok.RequiredArgsConstructor;
import org.shark.example.datasource.mysql.pojo.UserDo;
import org.shark.example.datasource.mysql.repository.UserRepository;
import org.shark.example.service.pojo.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public ResponseDto<List<UserDo>> start() {
        List<UserDo> list = userRepository.findAll();
        return ResponseDto.<List<UserDo>>builder().data(list).status(true).build();
    }
}
