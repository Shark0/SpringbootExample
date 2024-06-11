package org.shark.example.service.mysql;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.shark.example.controller.mysql.pojo.JsonInnerJoinDto;
import org.shark.example.dao.repository.JsonExampleRepository;
import org.shark.example.dao.repository.pojo.JsonInnerJoinDo;
import org.shark.example.service.mysql.pojo.CreateJsonExampleDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FindJsonInnerJoinResultService {
    private final JsonExampleRepository jsonExampleRepository;

    public List<JsonInnerJoinDto> start() {
        Gson gson = new Gson();
        List<JsonInnerJoinDo> jsonInnerJoinDoList = jsonExampleRepository.findAllJoin();
        List<JsonInnerJoinDto> list = new ArrayList<>();
        for(JsonInnerJoinDo jsonInnerJoinDo: jsonInnerJoinDoList) {
            JsonInnerJoinDto jsonInnerJoinDto = new JsonInnerJoinDto();
            jsonInnerJoinDto.setId(jsonInnerJoinDo.getId());
            jsonInnerJoinDto.setDescription(jsonInnerJoinDo.getDescription());
            jsonInnerJoinDto.setCreateJsonExampleDto(gson.fromJson(jsonInnerJoinDo.getJsonData(), CreateJsonExampleDto.class));
            list.add(jsonInnerJoinDto);
        }
        return list ;
    }
}
