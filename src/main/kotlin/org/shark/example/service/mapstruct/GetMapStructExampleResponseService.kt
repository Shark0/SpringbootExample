package org.shark.example.service.mapstruct

import org.shark.example.controller.mapstruct.pojo.MapStructResponseDto
import org.shark.example.controller.mapstruct.pojo.MapStructResponseMapper
import org.shark.example.service.mapstruct.pojo.MapStructExampleServiceDto
import org.springframework.stereotype.Service

@Service
class GetMapStructExampleResponseService(
    private val mapStructResponseMapper: MapStructResponseMapper
) {

    fun start(): MapStructResponseDto {
        val serviceDto = MapStructExampleServiceDto()
        serviceDto.serviceValue1 = "value1"
        serviceDto.serviceValue2 = "value2"
        serviceDto.serviceValue3 = "value3"
        return mapStructResponseMapper.toResponse(serviceDto)
    }
}
