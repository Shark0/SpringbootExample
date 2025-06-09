package org.shark.example.controller.permission;

import lombok.RequiredArgsConstructor;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.permission.PermissionReadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/permission")
public class PermissionController {

    private final PermissionReadService permissionReadService;

    @GetMapping
    public ResponseDto<Void> read() {
        permissionReadService.start();
        return ResponseDto.<Void>builder().status(true).build();
    }
}
