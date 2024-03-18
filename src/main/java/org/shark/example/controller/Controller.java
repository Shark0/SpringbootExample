package org.shark.example.controller;

import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public ResponseDto<Void> get() {
        return ResponseDto.<Void>builder().status(true).build();
    }
}
