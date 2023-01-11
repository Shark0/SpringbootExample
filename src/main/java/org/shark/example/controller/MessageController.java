package org.shark.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.message.GetMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/message")
@Slf4j
public class MessageController {

    private final GetMessageService getMessageService;

    @GetMapping
    public ResponseDto getMessage(@RequestParam String value1, @RequestParam Integer value2) {
        return getMessageService.start(value1, value2);
    }
}
