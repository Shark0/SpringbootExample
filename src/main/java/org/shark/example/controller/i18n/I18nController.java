package org.shark.example.controller.i18n;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.i18n.GetI18nService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/i18n")
@Slf4j
public class I18nController {

    private final GetI18nService getI18nService;

    @GetMapping
    public ResponseDto<String> getMessage(@RequestParam String value1, @RequestParam Integer value2) {
        return getI18nService.start(value1, value2);
    }
}
