package org.shark.example.domain.user.inbound.web;

import lombok.RequiredArgsConstructor;
import org.shark.example.domain.user.application.RegisterUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final RegisterUserService registerUserService;

    @PostMapping
    public void register(@RequestParam String name, @RequestParam String email) {
        registerUserService.register(name, email);
    }
}
