package org.shark.example.controller.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.controller.redis.pojo.KeyObjectDto;
import org.shark.example.controller.redis.pojo.KeyStringDto;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/string")
@Slf4j
public class RedisStringController {

    private final StringRedisTemplate stringRedisTemplate;

    private final RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/key/string")
    public ResponseDto<Void> setStringOptKey(
            @RequestBody KeyStringDto setStringOptRedisKeyDto) {

        stringRedisTemplate.opsForValue().set(setStringOptRedisKeyDto.getKey(), setStringOptRedisKeyDto.getValue());
        return ResponseDto.<Void>builder().status(true).build();
    }

    @PostMapping("/key/string/watch")
    public ResponseDto<Void> setStringOptKeyByWatch(
            @RequestBody KeyStringDto setStringOptRedisKeyDto) {

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


    @GetMapping("/key/{key}/value")
    public ResponseDto<String> getStringOptValue(@PathVariable String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return ResponseDto.<String>builder().data(value).status(true).build();
    }

    @PostMapping("/key/object")
    public ResponseDto<Void> setObjectOptKey(
            @RequestBody KeyObjectDto keyObjectDto) {
        redisTemplate.opsForValue().set(keyObjectDto.getKey(), keyObjectDto.getValue());
        return ResponseDto.<Void>builder().status(true).build();
    }

    @GetMapping("/key/{key}/object")
    public ResponseDto<Object> getObjectValue(@PathVariable String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return ResponseDto.builder().data(value).status(true).build();
    }

    @PutMapping("/incr/key/{key}")
    public ResponseDto<Long> incrValue(@PathVariable String key) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        Long newValue = operations.increment(key, 1);
        return ResponseDto.<Long>builder().data(newValue).status(true).build();
    }

    @PutMapping("/decr/key/{key}")
    public ResponseDto<Long> decrValue(@PathVariable String key) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        Long newValue = operations.decrement(key, 1);
        return ResponseDto.<Long>builder().data(newValue).status(true).build();
    }
}
