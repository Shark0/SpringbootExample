package org.shark.example.service.mysql;

import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.TimeExampleRepository;
import org.shark.example.dao.repository.pojo.TimeExampleDo;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.mysql.pojo.CreateDateTimeDto;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class CreateDateTimeService {

    private final TimeExampleRepository timeExampleRepository;

    public ResponseDto<TimeExampleDo> start(CreateDateTimeDto createDateTimeDto) {
        TimeExampleDo timeExampleDo = new TimeExampleDo();
        timeExampleDo.setDescription(createDateTimeDto.getDescription());
        timeExampleDo.setCreateTime(Instant.now());
        timeExampleDo = timeExampleRepository.save(timeExampleDo);
        return ResponseDto.<TimeExampleDo>builder().data(timeExampleDo)
                .status(true).build();
    }
}
