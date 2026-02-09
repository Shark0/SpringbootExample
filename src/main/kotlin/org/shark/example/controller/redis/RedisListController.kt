package org.shark.example.controller.redis

import com.google.gson.Gson
import org.shark.example.controller.redis.pojo.KeyStringDto
import org.shark.example.service.base.pojo.ResponseDto
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/redis/list")
class RedisListController(
    private val stringRedisTemplate: StringRedisTemplate
) {
    private val log = LoggerFactory.getLogger(RedisListController::class.java)

    @PostMapping
    fun set(@RequestBody setStringOptRedisKeyDto: KeyStringDto): ResponseDto<Long> {
        val count = if (setStringOptRedisKeyDto.key != null && setStringOptRedisKeyDto.value != null) {
            stringRedisTemplate.opsForList().rightPush(setStringOptRedisKeyDto.key, setStringOptRedisKeyDto.value)
        } else {
            0L
        }
        return ResponseDto(data = count, status = true)
    }

    @GetMapping("/key/{key}")
    fun get(@PathVariable key: String): ResponseDto<List<String>> {
        val length = stringRedisTemplate.opsForList().size(key) ?: 0
        val list = stringRedisTemplate.opsForList().range(key, 0, length)
        log.info(Gson().toJson(list))
        return ResponseDto(data = list, status = true)
    }
}
