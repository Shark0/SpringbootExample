package org.shark.example.service.rabbitmq.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageQueueInputDto implements Serializable {
    private String data;
}
