package org.shark.example.datasource.mongo.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
public class ExampleDo {
    @Id
    private String id;
    private Map<String, String> map;
    private List<String> list;
}
