package org.shark.example.controller.redis

import org.shark.example.controller.redis.pojo.KeyObjectDto
import org.shark.example.controller.redis.pojo.KeyStringDto
import org.shark.example.service.base.pojo.ResponseDto
import org.slf4j.LoggerFactory
import org.springframework.dao.DataAccessException
import org.springframework.data.redis.core.RedisOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.SessionCallback
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/redis/string")
class RedisStringController(
    private val stringRedisTemplate: StringRedisTemplate,
    private val redisTemplate: RedisTemplate<String, Any>
) {
    private val log = LoggerFactory.getLogger(RedisStringController::class.java)

    @PostMapping("/key/string")
    fun setStringOptKey(@RequestBody setStringOptRedisKeyDto: KeyStringDto): ResponseDto<Void> {
        if (setStringOptRedisKeyDto.key != null && setStringOptRedisKeyDto.value != null) {
            stringRedisTemplate.opsForValue().set(setStringOptRedisKeyDto.key, setStringOptRedisKeyDto.value)
        }
        return ResponseDto(status = true)
    }

    @PostMapping("/key/string/watch")
    fun setStringOptKeyByWatch(@RequestBody setStringOptRedisKeyDto: KeyStringDto): ResponseDto<Void> {
        stringRedisTemplate.execute(object : SessionCallback<Any?> {
            @Throws(DataAccessException::class)
            override fun <K : Any, V : Any> execute(operations: RedisOperations<K, V>): Any? {
                val stringOperations = operations as RedisOperations<String, String>
                if (setStringOptRedisKeyDto.key != null && setStringOptRedisKeyDto.value != null) {
                    stringOperations.watch(setStringOptRedisKeyDto.key)
                    stringOperations.multi()
                    stringOperations.opsForValue().set(setStringOptRedisKeyDto.key, setStringOptRedisKeyDto.value)
                    try {
                        Thread.sleep(10000)
                        stringOperations.exec()
                    } catch (e: Exception) {
                        e.printStackTrace()
                        throw RuntimeException(e)
                    }
                }
                return null
            }
        })
        return ResponseDto(status = true)
    }

    @GetMapping("/key/{key}/value")
    fun getStringOptValue(@PathVariable key: String): ResponseDto<String> {
        val value = stringRedisTemplate.opsForValue().get(key)
        return ResponseDto(data = value, status = true)
    }

    @PostMapping("/key/object")
    fun setObjectOptKey(@RequestBody keyObjectDto: KeyObjectDto): ResponseDto<Void> {
        if (keyObjectDto.key != null && keyObjectDto.value != null) {
            redisTemplate.opsForValue().set(keyObjectDto.key, keyObjectDto.value)
        }
        return ResponseDto(status = true)
    }

    @GetMapping("/key/{key}/object")
    fun getObjectValue(@PathVariable key: String): ResponseDto<Any> {
        val value = redisTemplate.opsForValue().get(key)
        return ResponseDto(data = value, status = true)
    }

    @PutMapping("/incr/key/{key}")
    fun incrValue(@PathVariable key: String): ResponseDto<Long> {
        val operations = redisTemplate.opsForValue()
        val newValue = operations.increment(key, 1)
        return ResponseDto(data = newValue, status = true)
    }

    @PutMapping("/decr/key/{key}")
    fun decrValue(@PathVariable key: String): ResponseDto<Long> {
        val operations = redisTemplate.opsForValue()
        val newValue = operations.decrement(key, 1)
        return ResponseDto(data = newValue, status = true)
    }
}
