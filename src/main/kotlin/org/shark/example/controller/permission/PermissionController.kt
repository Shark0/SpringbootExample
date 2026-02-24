package org.shark.example.controller.permission

import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.permission.PermissionReadService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/permission")
class PermissionController(private val permissionReadService: PermissionReadService) {

    @GetMapping
    fun read(): ResponseDto<Void> {
        permissionReadService.start()
        return ResponseDto(status = true)
    }
}
