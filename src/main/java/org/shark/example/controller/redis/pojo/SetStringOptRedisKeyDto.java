package org.shark.example.controller.redis.pojo;

import lombok.Data;

@Data
public class SetStringOptRedisKeyDto {
    private String key;
    private String value;
}
