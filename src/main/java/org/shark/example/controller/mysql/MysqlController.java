package org.shark.example.controller.mysql;

import lombok.RequiredArgsConstructor;
import org.shark.example.controller.mysql.pojo.JsonInnerJoinDto;
import org.shark.example.dao.repository.pojo.TaskDo;
import org.shark.example.dao.repository.pojo.TaskHistoryDo;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.mysql.*;
import org.shark.example.service.mysql.pojo.CreateJsonExampleDto;
import org.shark.example.service.mysql.pojo.CreateJsonJoinExampleDto;
import org.shark.example.service.mysql.pojo.CreateTaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mysql")
public class MysqlController {

    private final CreateTaskService createTaskService;

    @PostMapping("task")
    public ResponseDto<Void> createDateTime(@RequestBody CreateTaskDto createTaskDto) {
        createTaskService.start(createTaskDto);
        return ResponseDto.<Void>builder().status(true).build();
    }

    private final FindTaskService findTaskService;

    @GetMapping("task")
    public ResponseDto<List<TaskDo>> findTask(
            @RequestParam Integer page, @RequestParam Integer size) {
        List<TaskDo> taskDoList = findTaskService.start(page, size);
        return ResponseDto.<List<TaskDo>>builder().status(true).data(taskDoList).build();
    }

    private final FindTaskHistoryService findTaskHistoryService;

    @GetMapping("task-history")
    public ResponseDto<List<TaskHistoryDo>> findTaskHistory(
            @RequestParam Integer page, @RequestParam Integer size) {
        List<TaskHistoryDo> taskHistoryDoList = findTaskHistoryService.start(page, size);
        return ResponseDto.<List<TaskHistoryDo>>builder().status(true).data(taskHistoryDoList).build();
    }

    private final CreateJsonExampleService createJsonExampleService;

    @PostMapping("json-example")
    public ResponseDto<Void> createJsonExample(@RequestBody CreateJsonExampleDto createJsonExampleDto) {
        createJsonExampleService.createJsonExample(createJsonExampleDto);
        return ResponseDto.<Void>builder().status(true).build();
    }

    private final CreateJsonJoinExampleService createJsonJoinExampleService;

    @PostMapping("json-join-example")
    public ResponseDto<Void> createJsonExample(@RequestBody CreateJsonJoinExampleDto createJsonJoinExampleDto) {
        createJsonJoinExampleService.createJsonExample(createJsonJoinExampleDto);
        return ResponseDto.<Void>builder().status(true).build();
    }

    private final FindJsonInnerJoinResultService findJsonInnerJoinResultService;

    @GetMapping("json-inner-join")
    public ResponseDto<List<JsonInnerJoinDto>> findJsonInnerJoin() {
        List<JsonInnerJoinDto> list = findJsonInnerJoinResultService.start();
        return ResponseDto.<List<JsonInnerJoinDto>>builder().data(list).status(true).build();
    }
}
