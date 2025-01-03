package org.shark.example.datasource.cassandra.pojo;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@Table("message")
public class MessageDo {

    @PrimaryKey
    private MessageKeyDo messageKey;

    @Column("time")
    private Date time;
}
