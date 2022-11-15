package org.shark.example.service.messageQueue;

import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.messageQueue.pojo.MessageQueueDto;
import org.shark.example.service.messageQueue.pojo.MessageQueueInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SendMessageQueueService {
    @Resource(name = "exampleRabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    public ResponseDto<Void> start(MessageQueueInputDto messageQueueInputDto) {
        MessageQueueDto messageQueueDto = new MessageQueueDto();
        messageQueueDto.setUuid(UUID.randomUUID().toString());
        messageQueueDto.setData(messageQueueInputDto.getData());
        rabbitTemplate.convertAndSend("example", messageQueueDto);
        return ResponseDto.<Void>builder().status(1).build();
    }
}
