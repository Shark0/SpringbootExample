package org.shark.example.domain.user.model;

import lombok.Data;

@Data
public class UserDto {
    private final String id;
    private final String name;
    private final String email;
}
