package org.shark.example.service.mysql;

import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.TaskHistoryRepository;
import org.shark.example.dao.repository.pojo.TaskHistoryDo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindTaskHistoryService {

    private final TaskHistoryRepository taskHistoryRepository;
    public List<TaskHistoryDo> start(Integer page, Integer size) {
        int offset = page * size;
        return taskHistoryRepository.findByPage(size, offset);
    }
}
