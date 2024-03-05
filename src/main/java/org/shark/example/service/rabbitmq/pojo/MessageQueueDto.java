package org.shark.example.service.rabbitmq.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageQueueDto implements Serializable {
    private String uuid;
    private String data;
}
