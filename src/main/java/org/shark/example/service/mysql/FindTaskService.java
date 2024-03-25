
package org.shark.example.service.mysql;

import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.TaskRepository;
import org.shark.example.dao.repository.pojo.TaskDo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindTaskService {

    private final TaskRepository taskRepository;

    public List<TaskDo> start(Integer page, Integer size) {
        int offset = page * size;
        return taskRepository.findByPage(size, offset);
    }
}
