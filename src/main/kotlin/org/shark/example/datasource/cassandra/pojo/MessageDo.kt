package org.shark.example.datasource.cassandra.pojo

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.Date

@Table("message")
data class MessageDo(
    @PrimaryKey
    var messageKey: MessageKeyDo? = null,

    @Column("time")
    var time: Date? = null
)
