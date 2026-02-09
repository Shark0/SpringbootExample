package org.shark.example.domain.user.inbound.web

import org.shark.example.domain.user.application.RegisterUserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val registerUserService: RegisterUserService
) {
    @PostMapping
    fun register(@RequestParam name: String, @RequestParam email: String) {
        registerUserService.register(name, email)
    }
}
