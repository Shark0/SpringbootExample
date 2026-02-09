package org.shark.example.datasource.mongo

import org.shark.example.datasource.mongo.pojo.ExampleDo
import org.springframework.data.mongodb.repository.MongoRepository

interface ExampleRepository : MongoRepository<ExampleDo, String>
