package org.shark.example.controller.user;

import lombok.RequiredArgsConstructor;
import org.shark.example.datasource.mysql.pojo.UserDo;
import org.shark.example.service.pojo.ResponseDto;
import org.shark.example.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseDto<List<UserDo>> findAll() {
        return userService.start();
    }
}
