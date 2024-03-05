package org.shark.example.service.kafka;

import lombok.RequiredArgsConstructor;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PushKafkaMessageQueueService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ResponseDto<Void> start(MessageQueueInputDto messageQueueInputDto) {
        kafkaTemplate.send("message_topic", messageQueueInputDto.getData());
        return ResponseDto.<Void>builder().status(true).build();
    }
}
