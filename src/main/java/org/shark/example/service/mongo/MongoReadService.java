package org.shark.example.service.mongo;

import lombok.RequiredArgsConstructor;
import org.shark.example.datasource.mongo.ExampleRepository;
import org.shark.example.datasource.mongo.pojo.ExampleDo;
import org.shark.example.service.pojo.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MongoReadService {

    private final ExampleRepository exampleRepository;

    public ResponseDto<List<ExampleDo>> start() {
        return ResponseDto.<List<ExampleDo>>builder().status(true).data(exampleRepository.findAll()).build();
    }

}
