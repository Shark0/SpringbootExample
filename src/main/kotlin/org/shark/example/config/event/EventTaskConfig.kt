package org.shark.example.config.event

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor
import java.util.concurrent.ThreadPoolExecutor

@Configuration
class EventTaskConfig {

    @Bean("eventTaskExecutor")
    fun taskExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 64
        executor.maxPoolSize = 512
        executor.queueCapacity = 512
        executor.keepAliveSeconds = 60
        executor.setThreadNamePrefix("eventTaskExecutor-")
        executor.setRejectedExecutionHandler(ThreadPoolExecutor.CallerRunsPolicy())
        executor.setTaskDecorator(AsyncTaskDecorator())
        return executor
    }
}
