package org.shark.example.service.emqx;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.mqtt.MqttUseCase;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SendMessageService {

    private final MqttUseCase mqttUseCase;

    public ResponseDto<Void> start(String message) {
        mqttUseCase.pushMessage(message);
        return ResponseDto.<Void>builder()
                .status(true)
                .build();
    }
}
