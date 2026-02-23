package org.shark.example.config.asyncTask

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableAsync
class AsyncTaskConfig {

    @Bean(name = ["taskExecutor1"])
    fun taskExecutor1(): Executor {
        val threadPoolTaskExecutor = ThreadPoolTaskExecutor()
        threadPoolTaskExecutor.corePoolSize = 16
        threadPoolTaskExecutor.maxPoolSize = 32
        return threadPoolTaskExecutor
    }

    @Bean(name = ["taskExecutor2"])
    fun taskExecutor2(): Executor {
        val threadPoolTaskExecutor = ThreadPoolTaskExecutor()
        threadPoolTaskExecutor.corePoolSize = 4
        threadPoolTaskExecutor.maxPoolSize = 32
        return threadPoolTaskExecutor
    }
}
