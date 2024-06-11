package org.shark.example.controller.mysql.pojo;

import lombok.Data;
import org.shark.example.dao.repository.pojo.JsonExampleDo;
import org.shark.example.service.mysql.pojo.CreateJsonExampleDto;

@Data
public class JsonInnerJoinDto {
    private Integer id;
    private CreateJsonExampleDto createJsonExampleDto;
    private String description;
}
