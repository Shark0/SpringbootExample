package org.shark.example.controller.mongo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.datasource.mongo.pojo.ExampleDo;
import org.shark.example.service.mongo.MongoCreateService;
import org.shark.example.service.mongo.MongoReadService;
import org.shark.example.service.pojo.ResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mongo")
@Slf4j
public class MongoController {

    private final MongoCreateService mongoCreateService;

    @PostMapping
    public ResponseDto<Void> create(@RequestBody ExampleDo exampleDo) {
        return mongoCreateService.start(exampleDo);
    }

    private final MongoReadService mongoReadService;

    @GetMapping
    public ResponseDto<List<ExampleDo>> read() {
        return mongoReadService.start();
    }

}
