package org.shark.example.controller.kafka;

import lombok.RequiredArgsConstructor;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.kafka.SendKafkaMessageQueueService;
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final SendKafkaMessageQueueService sendKafkaMessageQueueService;

    @PostMapping("/send")
    public ResponseDto<Void> send(@RequestBody MessageQueueInputDto messageQueueInputDto) {
        return sendKafkaMessageQueueService.start(messageQueueInputDto);
    }
}
