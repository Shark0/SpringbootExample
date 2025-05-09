package org.shark.example.config.event;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.event.MqttConnectionFailedEvent;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.UUID;
import java.util.concurrent.Executor;

@Slf4j
@Configuration
public class MqttConfig {

	@Value("${mqtt.host}")
	private String host;
	@Value("${mqtt.user}")
	private String user;
	@Value("${mqtt.password}")
	private String password;

	@Bean
	public MqttConnectOptions generateMqttConnectionOptions() {
		MqttConnectOptions mqttConnectionOptions = new MqttConnectOptions();
		mqttConnectionOptions.setServerURIs(new String[]{host});
		mqttConnectionOptions.setKeepAliveInterval(15);
		mqttConnectionOptions.setAutomaticReconnect(true);
		mqttConnectionOptions.setUserName(user);
		mqttConnectionOptions.setPassword(password.toCharArray());
		return mqttConnectionOptions;
	}

	@Bean
	public MessageChannel mqttOutputChannel() {
		return new DirectChannel();
	}

	@Bean
	@ServiceActivator(inputChannel = "mqttOutputChannel")
	public MessageHandler generatorMqttOutboundMessageHandler() {
		MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler (UUID.randomUUID().toString(), mqttPahoClientFactory());
		messageHandler.setAsync(true);
		messageHandler.setDefaultQos(0);
		return messageHandler;
	}

	@Bean
	public MqttPahoClientFactory mqttPahoClientFactory() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		factory.setConnectionOptions(generateMqttConnectionOptions());
		return factory;
	}

	@Bean
	public ApplicationListener<?> eventListener() {
		return (ApplicationListener<MqttConnectionFailedEvent>) event -> log.info("Mqtt Error:", event.getCause());
	}

	@Bean
	public Executor mqttPublish() {
		return generateThreadPoolTaskExecutor();
	}

	private ThreadPoolTaskExecutor generateThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(1024);
		threadPoolTaskExecutor.setMaxPoolSize(1024);
		threadPoolTaskExecutor.setThreadNamePrefix("Async-");
		threadPoolTaskExecutor.setTaskDecorator(new AsyncTaskDecorator());
		return threadPoolTaskExecutor;
	}

}
