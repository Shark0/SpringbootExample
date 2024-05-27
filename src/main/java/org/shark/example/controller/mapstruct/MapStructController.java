package org.shark.example.controller.mapstruct;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.controller.mapstruct.pojo.MapStructResponseDto;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.mapstruct.GetMapStructExampleResponseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mapstruct")
@Slf4j
public class MapStructController {

    private final GetMapStructExampleResponseService getMapStructExampleResponseService;

    @GetMapping
    public ResponseDto<MapStructResponseDto> example() {
        return ResponseDto.<MapStructResponseDto>builder().data(getMapStructExampleResponseService.start()).build();
    }
}