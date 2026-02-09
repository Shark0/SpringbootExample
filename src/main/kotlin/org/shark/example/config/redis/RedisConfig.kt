package org.shark.example.config.redis

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer

@Configuration
class RedisConfig {

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, Any> {
        val redisTemplate = RedisTemplate<String, Any>()
        redisTemplate.setConnectionFactory(redisConnectionFactory)
        redisTemplate.setDefaultSerializer(Jackson2JsonRedisSerializer(Any::class.java))
        redisTemplate.setEnableTransactionSupport(true)
        redisTemplate.afterPropertiesSet()
        return redisTemplate
    }
}
