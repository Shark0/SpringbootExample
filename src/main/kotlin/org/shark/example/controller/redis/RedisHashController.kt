package org.shark.example.controller.redis

import org.shark.example.controller.redis.pojo.KeyHashDto
import org.shark.example.service.base.pojo.ResponseDto
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/redis/hash")
class RedisHashController(
    private val stringRedisTemplate: StringRedisTemplate
) {
    private val log = LoggerFactory.getLogger(RedisHashController::class.java)

    @PostMapping
    fun set(@RequestBody keyHashDto: KeyHashDto): ResponseDto<Void> {
        if (keyHashDto.key != null && keyHashDto.value != null) {
            stringRedisTemplate.opsForHash<String, String>().putAll(keyHashDto.key, keyHashDto.value)
        }
        return ResponseDto(status = true)
    }

    @GetMapping("/key/{key}")
    fun get(@PathVariable key: String): ResponseDto<Map<Any, Any>> {
        val map = stringRedisTemplate.opsForHash<Any, Any>().entries(key)
        return ResponseDto(data = map, status = true)
    }
}
