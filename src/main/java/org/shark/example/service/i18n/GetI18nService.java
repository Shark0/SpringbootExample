package org.shark.example.service.i18n;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetI18nService {

    private final MessageSource messageSource;

    public ResponseDto<String> start(String value1, Integer value2) {
        log.info("Locale.getDefault() = {}", Locale.getDefault().toString());
        return ResponseDto.<String>builder().data(
                messageSource.getMessage("message1", new Object[]{value1, value2}, Locale.getDefault()))
                .status(true)
                .build();
    }
}
