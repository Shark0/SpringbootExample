package org.shark.example.controller.mapstruct.pojo

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants
import org.mapstruct.ReportingPolicy
import org.shark.example.service.mapstruct.pojo.MapStructExampleServiceDto

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
interface MapStructResponseMapper {

    @Mapping(target = "responseValue1", source = "serviceValue1")
    @Mapping(target = "responseValue2", source = "serviceValue2")
    @Mapping(target = "responseValue3", source = "serviceValue3")
    fun toResponse(serviceDto: MapStructExampleServiceDto): MapStructResponseDto
}
