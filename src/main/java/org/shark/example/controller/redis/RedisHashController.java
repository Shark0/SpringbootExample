package org.shark.example.controller.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.controller.redis.pojo.KeyHashDto;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/hash")
@Slf4j
public class RedisHashController {

    private final StringRedisTemplate stringRedisTemplate;

    @PostMapping
    public ResponseDto<Void> set(
            @RequestBody KeyHashDto keyHashDto) {
        stringRedisTemplate.opsForHash().putAll(keyHashDto.getKey(), keyHashDto.getValue());
        return ResponseDto.<Void>builder().status(true).build();
    }

    @GetMapping("/key/{key}")
    public ResponseDto<Map<Object, Object>> get(@PathVariable String key) {
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries(key);
        return ResponseDto.<Map<Object, Object>>builder().data(map).status(true).build();
    }
}
