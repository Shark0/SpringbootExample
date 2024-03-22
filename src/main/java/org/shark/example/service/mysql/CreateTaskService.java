package org.shark.example.service.mysql;

import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.TaskRepository;
import org.shark.example.dao.repository.pojo.TaskDo;
import org.shark.example.service.mysql.pojo.CreateTaskDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateTaskService {

    private final TaskRepository taskRepository;
    public void start(CreateTaskDto createTaskDto) {
        TaskDo taskDo = new TaskDo();
        taskDo.setStatus(0);
        taskDo.setName(createTaskDto.getName());
        taskRepository.save(taskDo);
    }
}
