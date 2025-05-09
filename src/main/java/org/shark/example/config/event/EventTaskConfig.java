package org.shark.example.config.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class EventTaskConfig {

	@Bean("eventTaskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(64);
		executor.setMaxPoolSize(512);
		executor.setQueueCapacity(512);
		executor.setKeepAliveSeconds(60);
		executor.setThreadNamePrefix("eventTaskExecutor-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.setTaskDecorator(new AsyncTaskDecorator());
		return executor;
	}
}
