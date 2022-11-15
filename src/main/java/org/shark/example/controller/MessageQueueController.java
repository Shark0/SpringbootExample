package org.shark.example.controller;

import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.messageQueue.SendMessageQueueService;
import org.shark.example.service.messageQueue.pojo.MessageQueueInputDto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/message")
@Slf4j
public class MessageQueueController {

    private final Gson gson = new Gson();
    private final SendMessageQueueService sendMessageQueueService;

    @PostMapping("/send")
    public ResponseDto send(@RequestBody MessageQueueInputDto messageQueueInputDto) {
        log.debug(String.format("messageQueueInputDto: %s", gson.toJson(messageQueueInputDto)));
        return sendMessageQueueService.start(messageQueueInputDto);
    }
}
