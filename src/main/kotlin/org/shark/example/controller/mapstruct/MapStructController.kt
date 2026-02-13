package org.shark.example.controller.mapstruct

import org.shark.example.controller.mapstruct.pojo.MapStructResponseDto
import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.mapstruct.GetMapStructExampleResponseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mapstruct")
class MapStructController(
    private val getMapStructExampleResponseService: GetMapStructExampleResponseService
) {

    @GetMapping
    fun example(): ResponseDto<MapStructResponseDto> {
        return ResponseDto(data = getMapStructExampleResponseService.start())
    }
}
