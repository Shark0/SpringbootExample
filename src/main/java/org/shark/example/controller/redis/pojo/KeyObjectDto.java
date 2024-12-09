package org.shark.example.controller.redis.pojo;

import lombok.Data;

@Data
public class KeyObjectDto {
    private String key;
    private Object value;
}
