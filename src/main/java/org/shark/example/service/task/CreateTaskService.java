package org.shark.example.service.task;

import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.TaskRepository;
import org.shark.example.dao.repository.pojo.TaskDo;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.task.pojo.CreateTaskDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CreateTaskService {
    private final TaskRepository taskRepository;

    public ResponseDto<Void> start(CreateTaskDto createTaskDto) {
        List<TaskDo> taskDoList = new ArrayList<>();
        for(int i = 0; i < createTaskDto.getCount(); i ++) {
            TaskDo taskDo = new TaskDo();
            taskDo.setName(createTaskDto.getName());
            taskDo.setStatus(0);
            taskDoList.add(taskDo);
        }
        taskRepository.saveAll(taskDoList);
        return ResponseDto.<Void>builder().status(1).build();
    }
}
