package org.shark.example.controller.redis;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.controller.redis.pojo.KeyStringDto;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/list")
@Slf4j
public class RedisListController {

    private final StringRedisTemplate stringRedisTemplate;

    @PostMapping
    public ResponseDto<Long> set(
            @RequestBody KeyStringDto setStringOptRedisKeyDto) {
        Long count = stringRedisTemplate.opsForList().rightPush(setStringOptRedisKeyDto.getKey(), setStringOptRedisKeyDto.getValue());
        return ResponseDto.<Long>builder().data(count).status(true).build();
    }

    @GetMapping("/key/{key}")
    public ResponseDto<List<String>> get(@PathVariable String key) {
        Long length = stringRedisTemplate.opsForList().size(key);
        List<String> list = stringRedisTemplate.opsForList().range(key, 0, length);
        log.info(new Gson().toJson(list));
        return ResponseDto.<List<String>>builder().data(list).status(true).build();
    }
}
