package org.shark.example.datasource.cassandra.pojo;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@Data
@PrimaryKeyClass
public class MessageKeyDo {
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long userId;

    @PrimaryKeyColumn(name = "user_service", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String userService;

    @PrimaryKeyColumn(name = "item_id", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    private Long itemId;
}
