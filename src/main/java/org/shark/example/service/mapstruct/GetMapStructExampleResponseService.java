package org.shark.example.service.mapstruct;

import lombok.RequiredArgsConstructor;
import org.shark.example.controller.mapstruct.pojo.MapStructResponseDto;
import org.shark.example.controller.mapstruct.pojo.MapStructResponseMapper;
import org.shark.example.service.mapstruct.pojo.MapStructExampleServiceDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetMapStructExampleResponseService {

    private final MapStructResponseMapper mapStructResponseMapper;

    public MapStructResponseDto start() {
        MapStructExampleServiceDto serviceDto = new MapStructExampleServiceDto();
        serviceDto.setServiceValue1("value1");
        serviceDto.setServiceValue2("value2");
        serviceDto.setServiceValue3("value3");
        return mapStructResponseMapper.toResponse(serviceDto);
    }
}
