package org.shark.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.task.CreateTaskService;
import org.shark.example.service.task.pojo.CreateTaskDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    private final CreateTaskService createTaskService;

    @PostMapping
    public ResponseDto<Void> createTask(CreateTaskDto createTaskDto) {
        return createTaskService.start(createTaskDto);
    }
}
