package org.shark.example.service.mysql;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.shark.example.dao.repository.JsonExampleRepository;
import org.shark.example.dao.repository.pojo.JsonExampleDo;
import org.shark.example.service.mysql.pojo.CreateJsonExampleDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateJsonExampleService {

    private final JsonExampleRepository jsonExampleRepository;

    public void createJsonExample(CreateJsonExampleDto createJsonExampleDto) {
        String jsonData = new Gson().toJson(createJsonExampleDto);
        JsonExampleDo jsonExampleDo = new JsonExampleDo();
        jsonExampleDo.setJsonData(jsonData);
        jsonExampleRepository.save(jsonExampleDo);
    }
}
