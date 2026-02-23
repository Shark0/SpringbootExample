package org.shark.example.config.event

import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory
import org.springframework.integration.mqtt.core.MqttPahoClientFactory
import org.springframework.integration.mqtt.event.MqttConnectionFailedEvent
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.MessageHandler
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.UUID
import java.util.concurrent.Executor
import org.slf4j.LoggerFactory

@Configuration
class MqttConfig {

    private val log = LoggerFactory.getLogger(MqttConfig::class.java)

    @Value("\${mqtt.host}")
    private lateinit var host: String

    @Value("\${mqtt.user}")
    private lateinit var user: String

    @Value("\${mqtt.password}")
    private lateinit var password: String

    @Bean
    fun generateMqttConnectionOptions(): MqttConnectOptions {
        val mqttConnectionOptions = MqttConnectOptions()
        mqttConnectionOptions.serverURIs = arrayOf(host)
        mqttConnectionOptions.keepAliveInterval = 15
        mqttConnectionOptions.isAutomaticReconnect = true
        mqttConnectionOptions.userName = user
        mqttConnectionOptions.password = password.toCharArray()
        return mqttConnectionOptions
    }

    @Bean
    fun mqttOutputChannel(): MessageChannel {
        return DirectChannel()
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutputChannel")
    fun generatorMqttOutboundMessageHandler(): MessageHandler {
        val messageHandler = MqttPahoMessageHandler(UUID.randomUUID().toString(), mqttPahoClientFactory())
        messageHandler.setAsync(true)
        messageHandler.setDefaultQos(0)
        return messageHandler
    }

    @Bean
    fun mqttPahoClientFactory(): MqttPahoClientFactory {
        val factory = DefaultMqttPahoClientFactory()
        factory.connectionOptions = generateMqttConnectionOptions()
        return factory
    }

    @Bean
    fun eventListener(): ApplicationListener<*> {
        return ApplicationListener<MqttConnectionFailedEvent> { event ->
            log.info("Mqtt Error:", event.cause)
        }
    }

    @Bean
    fun mqttPublish(): Executor {
        return generateThreadPoolTaskExecutor()
    }

    private fun generateThreadPoolTaskExecutor(): ThreadPoolTaskExecutor {
        val threadPoolTaskExecutor = ThreadPoolTaskExecutor()
        threadPoolTaskExecutor.corePoolSize = 1024
        threadPoolTaskExecutor.maxPoolSize = 1024
        threadPoolTaskExecutor.setThreadNamePrefix("Async-")
        threadPoolTaskExecutor.setTaskDecorator(AsyncTaskDecorator())
        return threadPoolTaskExecutor
    }
}
