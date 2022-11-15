package org.shark.example.rabbitMq;

import org.shark.example.service.base.pojo.FakeMessageQueueDto;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMqListener {

    @RabbitListener(queues = {"example"}, containerFactory = "exampleContainerFactory")
    public void receive(FakeMessageQueueDto fakeMessageQueueDto) {
        log.info("fakeMessageQueueDto: " + new Gson().toJson(fakeMessageQueueDto));
//        int exception = 1 / 0;
    }
}
