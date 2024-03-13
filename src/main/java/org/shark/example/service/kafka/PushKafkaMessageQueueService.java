package org.shark.example.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.Message;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PushKafkaMessageQueueService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ResponseDto<Void> start(MessageQueueInputDto messageQueueInputDto) {
        int batchSize = 10000;
        String message = messageQueueInputDto.getData();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < batchSize; i ++) {
            kafkaTemplate.send("message_topic", (message + i));
        }
        long endTime = System.currentTimeMillis();
        log.info("total time = {}", (endTime - startTime));
        return ResponseDto.<Void>builder().status(true).build();
    }
}
