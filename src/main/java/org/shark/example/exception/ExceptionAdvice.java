package org.shark.example.exception;

import org.shark.example.service.base.pojo.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler({Exception.class})
    public final ResponseDto<Void> errorMessageHandler(Exception e) {
        Map<String, String> result = new HashMap<>();
        result.put("result", "fail");
        result.put("message", e.getMessage());
        log.error(e.getMessage(), e);
        return ResponseDto.<Void>builder().status(-1).errorMessage(e.getMessage()).build();
    }
}
