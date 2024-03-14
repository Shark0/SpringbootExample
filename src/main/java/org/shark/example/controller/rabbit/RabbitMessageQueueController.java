package org.shark.example.controller.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.rabbitmq.SendRabbitMessageQueueService;
import org.shark.example.service.rabbitmq.pojo.MessageQueueInputDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rabbit-mq")
@Slf4j
public class RabbitMessageQueueController {
    private final SendRabbitMessageQueueService sendRabbitMessageQueueService;

    @PostMapping("/send")
    public ResponseDto<Void> send(@RequestBody MessageQueueInputDto messageQueueInputDto) {
        return sendRabbitMessageQueueService.start(messageQueueInputDto);
    }
}
