package org.shark.example.service.kafka;

import lombok.RequiredArgsConstructor;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.rabbitmq.pojo.MessageQueueDto;
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PushKafkaJsonQueueService {

    private final KafkaTemplate<String, MessageQueueDto> kafkaTemplate;

    public ResponseDto<Void> start(MessageQueueInputDto messageQueueInputDto) {
        MessageQueueDto messageQueueDto = new MessageQueueDto();
        messageQueueDto.setData(messageQueueInputDto.getData());
        messageQueueDto.setUuid(UUID.randomUUID().toString());
        kafkaTemplate.send("json_topic", messageQueueDto);
        return ResponseDto.<Void>builder().status(true).build();
    }
}
