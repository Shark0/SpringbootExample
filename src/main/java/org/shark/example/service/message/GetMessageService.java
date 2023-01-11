package org.shark.example.service.message;

import lombok.RequiredArgsConstructor;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetMessageService {

    private final MessageSource messageSource;

    public ResponseDto<String> start(String value1, Integer value2) {
        return ResponseDto.<String>builder().data(
                messageSource.getMessage("message1", new Object[]{value1, value2}, null)).build();
    }
}
