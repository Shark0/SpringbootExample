package org.shark.example.controller.mapstruct.pojo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.shark.example.service.mapstruct.pojo.MapStructExampleServiceDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapStructResponseMapper {

    @Mapping(target = "responseValue1", expression = "java(serviceDto.getServiceValue1())")
    @Mapping(target = "responseValue2", expression = "java(serviceDto.getServiceValue2())")
    @Mapping(target = "responseValue3", expression = "java(serviceDto.getServiceValue3())")
    MapStructResponseDto toResponse(MapStructExampleServiceDto serviceDto);
}
