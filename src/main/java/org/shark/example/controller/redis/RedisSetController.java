package org.shark.example.controller.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.controller.redis.pojo.KeyStringDto;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/set")
@Slf4j
public class RedisSetController {

    private final StringRedisTemplate stringRedisTemplate;

    @PostMapping
    public ResponseDto<Void> set(
            @RequestBody KeyStringDto setStringOptRedisKeyDto) {
        stringRedisTemplate.opsForSet().add(setStringOptRedisKeyDto.getKey(), setStringOptRedisKeyDto.getValue());
        return ResponseDto.<Void>builder().status(true).build();
    }

    @GetMapping("/key/{key}")
    public ResponseDto<Set<String>> get(@PathVariable String key) {
        Set<String> set = stringRedisTemplate.opsForSet().members(key);
        return ResponseDto.<Set<String>>builder().data(set).status(true).build();
    }
}
