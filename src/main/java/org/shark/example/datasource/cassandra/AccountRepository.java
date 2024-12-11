package org.shark.example.datasource.cassandra;

import org.shark.example.datasource.cassandra.pojo.AccountDo;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface AccountRepository extends CassandraRepository<AccountDo, UUID> {

}
