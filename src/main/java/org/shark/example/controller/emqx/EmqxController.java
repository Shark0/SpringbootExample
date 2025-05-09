package org.shark.example.controller.emqx;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.emqx.SendMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/emqx")
@Slf4j
public class EmqxController {

    private final SendMessageService gsendMessageServicetI18nService;

    @GetMapping
    public ResponseDto<Void> getMessage(@RequestParam String message) {
        return gsendMessageServicetI18nService.start(message);
    }
}
