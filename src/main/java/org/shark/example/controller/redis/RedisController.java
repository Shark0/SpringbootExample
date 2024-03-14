package org.shark.example.controller.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.controller.redis.pojo.SetObjectOptRedisKeyDto;
import org.shark.example.controller.redis.pojo.SetStringOptRedisKeyDto;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
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
        return ResponseDto.<Void>builder().status(true).build();
    }

    @PostMapping("/string-opt-value-watch")
    public ResponseDto<Void> setStringOptKeyByWatch(
            @RequestBody SetStringOptRedisKeyDto setStringOptRedisKeyDto) {

        stringRedisTemplate.execute(new SessionCallback<>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.watch(setStringOptRedisKeyDto.getKey());
                operations.multi();
                operations.opsForValue().set(setStringOptRedisKeyDto.getKey(), setStringOptRedisKeyDto.getValue());
                try {
                    Thread.sleep(10000);
                    operations.exec();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }

                return null;
            }
        });
        return ResponseDto.<Void>builder().status(true).build();
    }


    @GetMapping("/string-opt-value/{key}")
    public ResponseDto<String> getStringOptValue(@PathVariable String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return ResponseDto.<String>builder().data(value).status(true).build();
    }

    @PostMapping("/object-opt-value")
    public ResponseDto<Void> setObjectOptKey(
            @RequestBody SetObjectOptRedisKeyDto setObjectOptRedisKeyDto) {
        redisTemplate.opsForValue().set(setObjectOptRedisKeyDto.getKey(), setObjectOptRedisKeyDto.getValue());
        return ResponseDto.<Void>builder().status(true).build();
    }

    @GetMapping("/object-opt-value/{key}")
    public ResponseDto<Object> getObjectOptValue(@PathVariable String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return ResponseDto.builder().data(value).status(true).build();
    }
}
