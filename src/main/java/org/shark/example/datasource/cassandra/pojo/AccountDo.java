package org.shark.example.datasource.cassandra.pojo;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table("account")
public class AccountDo {

    @CassandraType(type = CassandraType.Name.UUID)
    @PrimaryKey
    private UUID id;

    private String account;

    private String password;
}
