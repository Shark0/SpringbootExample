package org.shark.example.service.base.pojo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDto<ResultData> {
    private Boolean status;
    private ResultData data;
    private String errorMessage;
}
