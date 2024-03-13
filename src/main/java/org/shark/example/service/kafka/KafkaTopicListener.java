package org.shark.example.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.rabbitmq.pojo.MessageQueueDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaTopicListener {

    @KafkaListener(topics = {"message_topic"}, groupId = "1", batch = "true")
    public void messageTopicListener(List<String> messageList) {
        log.info("messageList.size() = {}", messageList.size());
        for (String message : messageList) {
            log.info("message = {}", message);
        }
    }

    @KafkaListener(topics = {"json_topic"}, groupId = "2", batch = "true")
    public void jsonTopicListener(List<MessageQueueDto> messageQueueDtoList) {
        for (MessageQueueDto messageQueueDto : messageQueueDtoList) {
            log.info("messageQueueDto = {}", messageQueueDto);
        }
    }
}
