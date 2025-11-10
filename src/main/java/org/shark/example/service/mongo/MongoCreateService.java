package org.shark.example.service.mongo;

import lombok.RequiredArgsConstructor;
import org.shark.example.datasource.mongo.ExampleRepository;
import org.shark.example.datasource.mongo.pojo.ExampleDo;
import org.shark.example.service.pojo.ResponseDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MongoCreateService {

    private final ExampleRepository exampleRepository;

    public ResponseDto<Void> start(ExampleDo exampleDo) {
        exampleRepository.save(exampleDo);
        return ResponseDto.<Void>builder().status(true).build();
    }

}
