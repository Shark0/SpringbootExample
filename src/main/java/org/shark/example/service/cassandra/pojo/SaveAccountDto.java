package org.shark.example.service.cassandra.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaveAccountDto {
    @NotNull
    private String account;
    @NotNull
    private String password;
}
