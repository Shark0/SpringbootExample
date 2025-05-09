package org.shark.example.service.mqtt;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.config.event.MqttGateway;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Order(0)
@Component
public class MqttUseCase {
    private final MqttGateway mqttGateway;

    @Async("eventTaskExecutor")
    @EventListener
    public void pushMessage(String message) {
        String emqxMessage = "{\"message\": \"" + message + "\"}";
        log.info("emqx message: {}", emqxMessage);
        mqttGateway.publish("test", emqxMessage);
    }

}
