package org.shark.example.controller.kafka;

import lombok.RequiredArgsConstructor;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.kafka.PushKafkaMessageQueueService;
import org.shark.example.service.kafka.PushKafkaJsonQueueService;
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final PushKafkaMessageQueueService pushKafkaMessageQueueService;

    @PostMapping("/pushMessage")
    public ResponseDto<Void> pushMessage(@RequestBody MessageQueueInputDto messageQueueInputDto) {
        return pushKafkaMessageQueueService.start(messageQueueInputDto);
    }

    private final PushKafkaJsonQueueService pushKafkaJsonQueueService;

    @PostMapping("/pushJson")
    public ResponseDto<Void> pushJson(@RequestBody MessageQueueInputDto messageQueueInputDto) {
        return pushKafkaJsonQueueService.start(messageQueueInputDto);
    }
}
