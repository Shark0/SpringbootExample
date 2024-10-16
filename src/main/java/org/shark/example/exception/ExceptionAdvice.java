package org.shark.example.exception;

import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler({Exception.class})
    public final ResponseDto<Void> errorMessageHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseDto.<Void>builder().status(false).errorMessage(e.getMessage()).build();
    }

    @ExceptionHandler({TooManyRequestException.class})
    public final ResponseEntity<String> tooManyRequestErrorMessageHandler(TooManyRequestException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(429).body(e.getMessage());
    }
}
