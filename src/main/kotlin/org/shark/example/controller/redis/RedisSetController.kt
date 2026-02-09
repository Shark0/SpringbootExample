package org.shark.example.controller.redis

import org.shark.example.controller.redis.pojo.KeyStringDto
import org.shark.example.service.base.pojo.ResponseDto
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/redis/set")
class RedisSetController(
    private val stringRedisTemplate: StringRedisTemplate
) {
    private val log = LoggerFactory.getLogger(RedisSetController::class.java)

    @PostMapping
    fun set(@RequestBody setStringOptRedisKeyDto: KeyStringDto): ResponseDto<Void> {
        if (setStringOptRedisKeyDto.key != null && setStringOptRedisKeyDto.value != null) {
            stringRedisTemplate.opsForSet().add(setStringOptRedisKeyDto.key, setStringOptRedisKeyDto.value)
        }
        return ResponseDto(status = true)
    }

    @GetMapping("/key/{key}")
    fun get(@PathVariable key: String): ResponseDto<Set<String>> {
        val set = stringRedisTemplate.opsForSet().members(key)
        return ResponseDto(data = set, status = true)
    }
}
