package org.shark.example.config.kafka

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.shark.example.service.rabbitmq.pojo.MessageQueueDto
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.*
import org.springframework.kafka.support.converter.RecordMessageConverter
import org.springframework.kafka.support.converter.StringJsonMessageConverter
import org.springframework.kafka.support.serializer.JsonSerializer

@EnableKafka
@Configuration
class KafkaConfig {
    @Bean
    fun jsonConverter(): RecordMessageConverter {
        return StringJsonMessageConverter()
    }

    @Bean
    fun messageProducerFactory(): ProducerFactory<String, String> {
        val configProps: MutableMap<String, Any> = HashMap()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        configProps[ProducerConfig.MAX_REQUEST_SIZE_CONFIG] = "20971520"
        configProps[ProducerConfig.BATCH_SIZE_CONFIG] = 100000
        configProps[ProducerConfig.LINGER_MS_CONFIG] = 100
        configProps[ProducerConfig.COMPRESSION_TYPE_CONFIG] = "gzip"
        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun messageProducerTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(messageProducerFactory())
    }

    @Bean
    fun messageConsumerFactory(): ConsumerFactory<String, String> {
        val config: MutableMap<String, Any> = HashMap()
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        config[ConsumerConfig.GROUP_ID_CONFIG] = "1"
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        config[ConsumerConfig.MAX_POLL_RECORDS_CONFIG] = "10000"
        config[ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG] = "100"
        return DefaultKafkaConsumerFactory(config)
    }

    @Bean
    fun messageKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.consumerFactory = messageConsumerFactory()
        return factory
    }

    @Bean
    fun jsonProducerFactory(): ProducerFactory<String, MessageQueueDto> {
        val configProps: MutableMap<String, Any> = HashMap()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        configProps[ProducerConfig.MAX_REQUEST_SIZE_CONFIG] = "20971520"
        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun jsonProducerTemplate(): KafkaTemplate<String, MessageQueueDto> {
        return KafkaTemplate(jsonProducerFactory())
    }

    @Bean
    fun jsonConsumerFactory(): ConsumerFactory<String, MessageQueueDto> {
        val config: MutableMap<String, Any> = HashMap()
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        config[ConsumerConfig.GROUP_ID_CONFIG] = "1"
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        return DefaultKafkaConsumerFactory(config)
    }

    @Bean
    fun jsonKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, MessageQueueDto> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, MessageQueueDto>()
        factory.consumerFactory = jsonConsumerFactory()
        return factory
    }
}
