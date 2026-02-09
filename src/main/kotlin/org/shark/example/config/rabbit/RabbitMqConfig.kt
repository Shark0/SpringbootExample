package org.shark.example.config.rabbit

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
@EnableRabbit
class RabbitMqConfig {

    @Bean(name = ["exampleConnectionFactory"])
    @Primary
    fun exampleConnectionFactory(
            @Value("\${example.rabbitmq.host}") addresses: String,
            @Value("\${example.rabbitmq.port}") port: Int,
            @Value("\${example.rabbitmq.username}") username: String,
            @Value("\${example.rabbitmq.password}") password: String): CachingConnectionFactory {
        val connectionFactory = CachingConnectionFactory()
        connectionFactory.setAddresses(addresses)
        connectionFactory.port = port
        connectionFactory.username = username
        connectionFactory.setPassword(password)
        return connectionFactory
    }

    @Bean(name = ["exampleRabbitTemplate"])
    @Primary
    fun exampleRabbitTemplate(
            @Qualifier("exampleConnectionFactory") connectionFactory: ConnectionFactory
    ): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = Jackson2JsonMessageConverter()
        return rabbitTemplate
    }

    @Bean(name = ["exampleContainerFactory"])
    @Primary
    fun exampleFactory(
            @Qualifier("exampleConnectionFactory") connectionFactory: ConnectionFactory): SimpleRabbitListenerContainerFactory {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setMessageConverter(Jackson2JsonMessageConverter())
        factory.setConnectionFactory(connectionFactory)
        factory.setPrefetchCount(1)
        return factory
    }
}
