package org.shark.example.service.mysql;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.JsonJoinExampleRepository;
import org.shark.example.dao.repository.pojo.JsonExampleDo;
import org.shark.example.dao.repository.pojo.JsonJoinExampleDo;
import org.shark.example.service.mysql.pojo.CreateJsonJoinExampleDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateJsonJoinExampleService {

    private final JsonJoinExampleRepository jsonJoinExampleRepository;
    
    public void createJsonExample(CreateJsonJoinExampleDto createJsonJoinExampleDto) {
        JsonJoinExampleDo jsonJoinExampleDo = new JsonJoinExampleDo();
        jsonJoinExampleDo.setJsonExampleId(createJsonJoinExampleDto.getJsonExampleId());
        jsonJoinExampleDo.setDescription(createJsonJoinExampleDto.getDescription());
        jsonJoinExampleRepository.save(jsonJoinExampleDo);
    }
}
