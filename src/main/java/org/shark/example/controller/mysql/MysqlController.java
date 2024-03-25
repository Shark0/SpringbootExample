package org.shark.example.controller.mysql;

import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.pojo.TaskDo;
import org.shark.example.dao.repository.pojo.TaskHistoryDo;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.mysql.CreateTaskService;
import org.shark.example.service.mysql.FindTaskHistoryService;
import org.shark.example.service.mysql.FindTaskService;
import org.shark.example.service.mysql.pojo.CreateTaskDto;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
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
}
