package org.shark.example.datasource.mongo;

import org.shark.example.datasource.mongo.pojo.ExampleDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExampleRepository extends MongoRepository<ExampleDo, String> {

}
