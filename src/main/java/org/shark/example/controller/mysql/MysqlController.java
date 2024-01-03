package org.shark.example.controller.mysql;

import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.pojo.TimeExampleDo;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.mysql.CreateDateTimeService;
import org.shark.example.service.mysql.pojo.CreateDateTimeDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mysql")
public class MysqlController {

    private final CreateDateTimeService createDateTimeService;

    @PostMapping("datetime")
    public ResponseDto<TimeExampleDo> createDateTime(@RequestBody CreateDateTimeDto createDateTimeDto) {
        return createDateTimeService.start(createDateTimeDto);
    }
}
