package org.shark.example.config.rabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableRabbit
public class RabbitMqConfig {

    @Bean(name = "exampleConnectionFactory")
    @Primary
    public CachingConnectionFactory exampleConnectionFactory(
            @Value("${example.rabbitmq.host}") String addresses,
            @Value("${example.rabbitmq.port}") int port,
            @Value("${example.rabbitmq.username}") String username,
            @Value("${example.rabbitmq.password}") String password) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean(name = "exampleRabbitTemplate")
    @Primary
    public RabbitTemplate exampleRabbitTemplate(
            @Qualifier("exampleConnectionFactory") ConnectionFactory connectionFactory
    ) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean(name = "exampleContainerFactory")
    @Primary
    public SimpleRabbitListenerContainerFactory exampleFactory(
            @Qualifier("exampleConnectionFactory") ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setConnectionFactory(connectionFactory);
        factory.setPrefetchCount(1);
        return factory;
    }
}
