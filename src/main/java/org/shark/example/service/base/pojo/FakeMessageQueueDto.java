package org.shark.example.service.base.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FakeMessageQueueDto implements Serializable {
    private String uuid;
    private String data;
}
