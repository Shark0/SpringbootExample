package org.shark.example.service.time;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.TimeExampleRepository;
import org.shark.example.dao.repository.pojo.TimeExampleDo;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.time.pojo.CreateTimeExampleDto;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class CreateTimeExampleService {

    private final TimeExampleRepository timeExampleRepository;

    public ResponseDto<TimeExampleDo> start(CreateTimeExampleDto createTimeExampleDto) {
        TimeExampleDo timeExampleDo = new TimeExampleDo();
        timeExampleDo.setDescription(createTimeExampleDto.getDescription());
        timeExampleDo.setCreateTime(Instant.now());
        timeExampleDo = timeExampleRepository.save(timeExampleDo);
        return ResponseDto.<TimeExampleDo>builder().status(1).data(timeExampleDo).build();
    }
}
