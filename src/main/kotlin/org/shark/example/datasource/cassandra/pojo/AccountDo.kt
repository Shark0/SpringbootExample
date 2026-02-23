package org.shark.example.datasource.cassandra.pojo

import org.springframework.data.cassandra.core.mapping.CassandraType
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.UUID

@Table("account")
data class AccountDo(
    @CassandraType(type = CassandraType.Name.UUID)
    @PrimaryKey
    var id: UUID? = null,
    var account: String? = null,
    var password: String? = null
)
