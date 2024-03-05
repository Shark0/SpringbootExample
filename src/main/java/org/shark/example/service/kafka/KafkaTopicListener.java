package org.shark.example.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaTopicListener {

    @KafkaListener(topics = {"message_topic"}, groupId = "1")
    public void messageTopicListener(String message) {
        log.info("message = {}", message);
    }
}
