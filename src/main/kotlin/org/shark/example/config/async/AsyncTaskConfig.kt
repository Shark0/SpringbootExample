package org.shark.example.config.async

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableAsync
class AsyncTaskConfig {

    @Bean
    fun taskExecutor(): Executor {
        val threadPoolTaskExecutor = ThreadPoolTaskExecutor()
        threadPoolTaskExecutor.corePoolSize = 32
        threadPoolTaskExecutor.maxPoolSize = 64
        threadPoolTaskExecutor.queueCapacity = Int.MAX_VALUE
        return threadPoolTaskExecutor
    }
}
