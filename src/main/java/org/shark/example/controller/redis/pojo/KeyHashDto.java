package org.shark.example.controller.redis.pojo;

import lombok.Data;

import java.util.Map;

@Data
public class KeyHashDto {
    private String key;
    private Map<String, String> value;
}
