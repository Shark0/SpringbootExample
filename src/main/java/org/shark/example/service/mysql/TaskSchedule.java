package org.shark.example.service.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.dao.repository.TaskHistoryRepository;
import org.shark.example.dao.repository.TaskRepository;
import org.shark.example.dao.repository.pojo.TaskDo;
import org.shark.example.dao.repository.pojo.TaskHistoryDo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class TaskSchedule {

    private final TaskRepository taskRepository;
    private final TaskHistoryRepository taskHistoryRepository;

    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    public void doTask() {
        String workId = UUID.randomUUID().toString();
        taskRepository.updateWorkId(workId);
        TaskDo taskDo = taskRepository.findByWorkId(workId);
        if(taskDo == null) {
            return;
        }
        taskDo.setStatus(1);
        taskRepository.save(taskDo);
        TaskHistoryDo taskHistoryDo = new TaskHistoryDo();
        taskHistoryDo.setTaskId(taskDo.getId());
        taskHistoryDo.setWorkId(workId);
        taskHistoryDo.setStatus(1);
        taskHistoryRepository.save(taskHistoryDo);
    }
}
