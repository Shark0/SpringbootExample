package org.shark.example.rabbitMq;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMqListener {
//    @RabbitListener(queues = {"example"}, containerFactory = "exampleContainerFactory")
//    public void receiveMessage(Object object) {
//        log.info("message: {}", new Gson().toJson(object));
//    }
}
