package org.shark.example.controller;

import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.pojo.TimeExampleDo;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.time.CreateTimeExampleService;
import org.shark.example.service.time.pojo.CreateTimeExampleDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/timeExample")
public class TimeExampleController {

    private final CreateTimeExampleService createTimeExampleService;

    @PostMapping
    public ResponseDto<TimeExampleDo> createTime(@RequestBody CreateTimeExampleDto createTimeExampleDto) {
        return createTimeExampleService.start(createTimeExampleDto);
    }
}
