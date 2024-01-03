package org.shark.example.controller.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.controller.redis.pojo.SetObjectOptRedisKeyDto;
import org.shark.example.controller.redis.pojo.SetStringOptRedisKeyDto;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    private final StringRedisTemplate stringRedisTemplate;

    private final RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/string-opt-value")
    public ResponseDto<Void> setStringOptKey(
            @RequestBody SetStringOptRedisKeyDto setStringOptRedisKeyDto) {
        stringRedisTemplate.opsForValue().set(setStringOptRedisKeyDto.getKey(), setStringOptRedisKeyDto.getValue());
        return ResponseDto.<Void>builder().status(1).build();
    }

    @PostMapping("/string-opt-value/{key}")
    public ResponseDto<String> getStringOptValue(@PathVariable String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return ResponseDto.<String>builder().data(value).status(1).build();
    }

    @PostMapping("/object-opt-value")
    public ResponseDto<Void> setObjectOptKey(
            @RequestBody SetObjectOptRedisKeyDto setObjectOptRedisKeyDto) {
        redisTemplate.opsForValue().set(setObjectOptRedisKeyDto.getKey(), setObjectOptRedisKeyDto.getValue());
        return ResponseDto.<Void>builder().status(1).build();
    }

    @PostMapping("/object-opt-value/{key}")
    public ResponseDto<Object> getObjectOptValue(@PathVariable String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return ResponseDto.builder().data(value).status(1).build();
    }
}
