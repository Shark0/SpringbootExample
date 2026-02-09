package org.shark.example.datasource.cassandra.pojo

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn

@PrimaryKeyClass
data class MessageKeyDo(
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    var userId: Long? = null,

    @PrimaryKeyColumn(name = "user_service", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    var userService: String? = null,

    @PrimaryKeyColumn(name = "item_id", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    var itemId: Long? = null
)
