package org.shark.example.controller.log;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

    @GetMapping("/debug")
    public ResponseDto<Void> debug(@RequestParam("value") String value) {
        log.debug("value: {}", value);
        return ResponseDto.<Void>builder().build();
    }

    @GetMapping("/error")
    public ResponseDto<Void> error(@RequestParam("value") String value) {
        log.error("value: {}", value);
        return ResponseDto.<Void>builder().build();
    }
}
