package org.shark.example.service.base.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BeanToMapExampleDto implements Serializable {
    private Integer intValue;
    private String strValue;
    private List<BeanToMapExampleDto> exampleList;

}
